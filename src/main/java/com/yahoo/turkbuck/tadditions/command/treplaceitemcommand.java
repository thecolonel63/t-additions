package com.yahoo.turkbuck.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.yahoo.turkbuck.tadditions.command.helpers.CommandManager.addClientSideCommand;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class treplaceitemcommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        MinecraftClient MC = MinecraftClient.getInstance();

        addClientSideCommand("treplaceitem");

        dispatcher.register(literal("treplaceitem")
                .then(literal("armor.head")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(5, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(5, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(literal("armor.chest")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(6, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(6, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(literal("armor.legs")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(7, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(7, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(literal("armor.feet")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(8, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(8, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.0")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(9, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(9, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.1")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(10, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(10, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.2")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(11, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(11, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.3")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(12, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(12, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.4")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(13, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(13, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.5")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(14, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(14, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.6")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(15, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(15, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.7")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(16, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(16, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.8")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(17, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(17, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.9")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(18, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(18, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.10")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(19, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(19, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.11")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(20, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(20, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.12")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(21, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(21, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.13")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(22, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(22, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.14")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(23, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(23, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.15")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(24, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(24, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.16")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(25, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(25, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.17")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(26, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(26, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.18")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(27, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(27, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.19")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(28, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(28, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.20")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(29, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(29, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.21")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(30, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(30, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.22")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(31, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(31, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.23")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(32, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(32, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.24")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(33, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(33, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.25")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(34, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(34, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("inventory.26")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(35, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(35, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.0")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.1")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(37, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(37, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.2")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(38, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(38, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.3")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(39, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(39, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.4")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(40, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(40, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.5")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(41, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(41, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.6")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(42, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(42, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.7")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(43, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(43, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("hotbar.8")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(44, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(44, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("weapon")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("weapon.mainhand")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(literal("weapon.offhand")
                        .then(argument("item", itemStack())
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(45, stack);
                                    return 0;
                                })
                                .then(argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(45, stack);

                                            return 0;
                                        })
                                )
                        )
                )
        );
    }

    private static void replaceItem(Integer slot, ItemStack stack) {
        MinecraftClient MC = MinecraftClient.getInstance();
        if (MC.player.getAbilities().creativeMode) {
            if (stack.getCount() > 64) {
                MC.player.sendMessage(new TranslatableText("tadditions.count_above_max"), false);
            } else if (stack.getCount() < 1) {
                MC.player.sendMessage(new TranslatableText("tadditions.count_below_min"), false);
            } else {
                MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(slot, stack));
                MC.player.sendMessage(new TranslatableText("tadditions.replaceitem.success"), false);
            }
        } else {
            MC.player.sendMessage(new TranslatableText("tadditions.error.creative"), false);
        }
    }
}