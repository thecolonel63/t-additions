package com.thecolonel63.tadditions.command;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;


public class tgivecommand {

    public static void register() {

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("tgive")
                .then(ClientCommandManager.argument("item", itemStack())
                        .executes(context -> {
                            MinecraftClient MC = MinecraftClient.getInstance();
                            if (MC.player.getAbilities().creativeMode) {
                                ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                for (int i = 0; i < 9; i++) {
                                    if (MC.player.getInventory().getStack(i).isEmpty()) {
                                        MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + i, stack));
                                        MC.player.sendMessage(new TranslatableText("tadditions.give.success"), false);
                                        MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                                        return 0;
                                    }
                                }
                                MC.player.sendMessage(new TranslatableText("tadditions.error.hotbarfull"), false);
                                return 0;
                            } else {
                                MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
                                return 0;
                            }
                        })
                        .then(ClientCommandManager.argument("count", integer())
                                .executes(context -> {
                                    Integer count = context.getArgument("count", Integer.class);
                                    MinecraftClient MC = MinecraftClient.getInstance();
                                    if (count > 64) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.count_above_max"), false);
                                        return 0;
                                    } else if (count < 1) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.count_below_min"), false);
                                        return 0;
                                    }
                                    if (MC.player.getAbilities().creativeMode) {
                                        ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                        for (int i = 0; i < 9; i++) {
                                            if (MC.player.getInventory().getStack(i).isEmpty()) {
                                                MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + i, stack));
                                                MC.player.sendMessage(new TranslatableText("tadditions.give.success"), false);
                                                MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                                                return 0;
                                            }
                                        }
                                        MC.player.sendMessage(new TranslatableText("tadditions.error.hotbarfull"), false);
                                        return 0;
                                    } else {
                                        MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
                                        return 0;
                                    }
                                }))));
    }
}
