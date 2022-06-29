package com.thecolonel63.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.command.argument.ItemStackArgumentType.getItemStackArgument;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;


public class tgivecommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {

        dispatcher.register(ClientCommandManager.literal("tgive")
                .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                        .executes(context -> {
                            MinecraftClient MC = MinecraftClient.getInstance();
                            if (MC.player.getAbilities().creativeMode) {
                                ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                for (int i = 0; i < 9; i++) {
                                    if (MC.player.getInventory().getStack(i).isEmpty()) {
                                        MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + i, stack));
                                        MC.player.sendMessage(Text.translatable("tadditions.give.success"), false);
                                        MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                                        return 0;
                                    }
                                }
                                MC.player.sendMessage(Text.translatable("tadditions.error.hotbarfull"), false);
                                return 0;
                            } else {
                                MC.player.sendMessage(Text.translatable("tadditions.error.creative"), false);
                                return 0;
                            }
                        })
                        .then(ClientCommandManager.argument("count", integer())
                                .executes(context -> {
                                    Integer count = context.getArgument("count", Integer.class);
                                    MinecraftClient MC = MinecraftClient.getInstance();
                                    if (count > 64) {
                                        MC.player.sendMessage(Text.translatable("tadditions.count_above_max"), false);
                                        return 0;
                                    } else if (count < 1) {
                                        MC.player.sendMessage(Text.translatable("tadditions.count_below_min"), false);
                                        return 0;
                                    }
                                    if (MC.player.getAbilities().creativeMode) {
                                        ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                        for (int i = 0; i < 9; i++) {
                                            if (MC.player.getInventory().getStack(i).isEmpty()) {
                                                MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + i, stack));
                                                MC.player.sendMessage(Text.translatable("tadditions.give.success"), false);
                                                MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                                                return 0;
                                            }
                                        }
                                        MC.player.sendMessage(Text.translatable("tadditions.error.hotbarfull"), false);
                                        return 0;
                                    } else {
                                        MC.player.sendMessage(Text.translatable("tadditions.error.creative"), false);
                                        return 0;
                                    }
                                }))));
    }
}
