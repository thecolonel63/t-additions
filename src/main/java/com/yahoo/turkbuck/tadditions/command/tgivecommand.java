package com.yahoo.turkbuck.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.yahoo.turkbuck.tadditions.command.helpers.CommandManager.addClientSideCommand;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;


public class tgivecommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        addClientSideCommand("tgive");
        dispatcher.register(literal("tgive")
                .then(argument("item", itemStack())
                    .executes(context -> {
                        MinecraftClient MC = MinecraftClient.getInstance();
                        if (MC.player.getAbilities().creativeMode) {
                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                            for(int i = 0; i < 9; i++) {
                                if(MC.player.getInventory().getStack(i).isEmpty()) {
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
                    .then(argument("count", integer())
                        .executes(context -> {
                            MinecraftClient MC = MinecraftClient.getInstance();
                            Integer count = context.getArgument("count", Integer.class);
                            if(count > 64) {
                                MC.player.sendMessage(new TranslatableText("tadditions.count_above_max"), false);
                                return 0;
                            } else if (count < 1) {
                                MC.player.sendMessage(new TranslatableText("tadditions.count_below_min"), false);
                                return 0;
                            }
                            if (MC.player.getAbilities().creativeMode) {
                                ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                for(int i = 0; i < 9; i++) {
                                    if(MC.player.getInventory().getStack(i).isEmpty()) {
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
