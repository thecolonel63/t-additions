package com.yahoo.turkbuck.tadditions.command;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;

public class tgivecommand {

    public static void register() {
        MinecraftClient MC = MinecraftClient.getInstance();

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("tgive")
                .then(ClientCommandManager.argument("item", itemStack())
                        .executes(context -> {
                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                            MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + MC.player.getInventory().selectedSlot, stack));
                            MC.player.sendMessage(new TranslatableText("tadditions.give.success"), false);
                            MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                            return 0;
                        })
                        .then(ClientCommandManager.argument("count", integer())
                                .executes(context -> {
                                    Integer count = context.getArgument("count", Integer.class);
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                    if(stack.getCount() > 64) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.count_above_max"), false);
                                    } else if (stack.getCount() < 1) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.count_below_min"), false);
                                    } else {
                                        MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(36 + MC.player.getInventory().selectedSlot, stack));
                                        MC.player.sendMessage(new TranslatableText("tadditions.give.success"), false);
                                        MC.player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((MC.player.getRandom().nextFloat() - MC.player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                                    }
                                    return 0;
                                })
                        )
                )
        );
    }

}
