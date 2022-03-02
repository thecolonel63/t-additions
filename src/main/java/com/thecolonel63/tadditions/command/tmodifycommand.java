package com.thecolonel63.tadditions.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;

public class tmodifycommand {

    public static void register() {
        MinecraftClient MC = MinecraftClient.getInstance();
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("tmodify")
                .then(ClientCommandManager.literal("add")
                        .then(ClientCommandManager.argument("nbt", greedyString())
                                .executes(context -> {
                                    if (MC.player.getAbilities().creativeMode) {
                                        String nbt = context.getArgument("nbt", String.class);
                                        ItemStack stack = MC.player.getMainHandStack();
                                        addNbt(nbt, stack);
                                    } else {
                                        MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
                                    }
                                    return 0;
                                })))
                .then(ClientCommandManager.literal("set")
                        .then(ClientCommandManager.argument("nbt", greedyString())
                                .executes(context -> {
                                    if (MC.player.getAbilities().creativeMode) {
                                        String nbt = context.getArgument("nbt", String.class);
                                        ItemStack stack = MC.player.getMainHandStack();
                                        setNbt(nbt, stack);
                                    } else {
                                        MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
                                    }
                                    return 0;
                                })))
                .then(ClientCommandManager.literal("remove")
                        .then(ClientCommandManager.argument("nbt", greedyString())
                                .executes(context -> {
                                    if (MC.player.getAbilities().creativeMode) {
                                        String nbt = context.getArgument("nbt", String.class);
                                        ItemStack stack = MC.player.getMainHandStack();
                                        removeNbt(nbt, stack);
                                    } else {
                                        MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
                                    }
                                    return 0;
                                })))
        );
    }

    private static void addNbt(String nbt, ItemStack stack) {

        MinecraftClient MC = MinecraftClient.getInstance();

        if (!stack.hasNbt()) stack.setNbt(new NbtCompound());
        try {
            NbtCompound tag = StringNbtReader.parse(nbt);
            stack.getNbt().copyFrom(tag);
            MC.player.sendMessage(new TranslatableText("tadditions.modify.success"), false);
        } catch (CommandSyntaxException e) {
            MC.player.sendMessage(new TranslatableText("tadditions.modify.nbt.invalid"), false);
        }
    }

    private static void setNbt(String nbt, ItemStack stack) {

        MinecraftClient MC = MinecraftClient.getInstance();
        try {
            NbtCompound tag = StringNbtReader.parse(nbt);
            stack.setNbt(tag);
            MC.player.sendMessage(new TranslatableText("tadditions.modify.success"), false);
        } catch (CommandSyntaxException e) {
            MC.player.sendMessage(new TranslatableText("tadditions.modify.nbt.invalid"), false);
        }

    }

    private static void removeNbt(String nbt, ItemStack stack) {

        MinecraftClient MC = MinecraftClient.getInstance();

        NbtPath path = parseNbtPath(stack.getNbt(), nbt);

        if (path == null) {
            MC.player.sendMessage(new TranslatableText("tadditions.modify.nbt.path.invalid"), false);
        } else {
            path.base.remove(path.key);
            MC.player.sendMessage(new TranslatableText("tadditions.modify.success"), false);
        }

    }

    private static NbtPath parseNbtPath(NbtCompound tag, String path) {
        String[] parts = path.split("\\.");

        NbtCompound base = tag;
        if (base == null) return null;

        for (int i = 0; i < parts.length - 1; i++) {
            String part = parts[i];

            if (!base.contains(part) || !(base.get(part) instanceof NbtCompound)) return null;

            base = base.getCompound(part);
        }

        if (!base.contains(parts[parts.length - 1])) return null;

        return new NbtPath(base, parts[parts.length - 1]);
    }

    private static class NbtPath {
        public NbtCompound base;
        public String key;

        public NbtPath(NbtCompound base, String key) {
            this.base = base;
            this.key = key;
        }
    }
}
