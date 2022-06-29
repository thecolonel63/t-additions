package com.thecolonel63.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;

public class treplaceitemcommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        MinecraftClient MC = MinecraftClient.getInstance();

        dispatcher.register(ClientCommandManager.literal("treplaceitem")
                .then(ClientCommandManager.literal("armor.head")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(5, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(5, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(ClientCommandManager.literal("armor.chest")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(6, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(6, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(ClientCommandManager.literal("armor.legs")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(7, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(7, stack);
                                            return 0;
                                        })
                                )
                        )
                )

                .then(ClientCommandManager.literal("armor.feet")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(8, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(8, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.0")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(9, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(9, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.1")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(10, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(10, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.2")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(11, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(11, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.3")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(12, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(12, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.4")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(13, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(13, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.5")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(14, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(14, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.6")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(15, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(15, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.7")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(16, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(16, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.8")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(17, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(17, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.9")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(18, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(18, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.10")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(19, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(19, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.11")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(20, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(20, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.12")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(21, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(21, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.13")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(22, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(22, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.14")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(23, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(23, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.15")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(24, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(24, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.16")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(25, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(25, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.17")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(26, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(26, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.18")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(27, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(27, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.19")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(28, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(28, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.20")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(29, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(29, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.21")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(30, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(30, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.22")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(31, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(31, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.23")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(32, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(32, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.24")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(33, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(33, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.25")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(34, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(34, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("inventory.26")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(35, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(35, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.0")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.1")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(37, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(37, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.2")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(38, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(38, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.3")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(39, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(39, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.4")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(40, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(40, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.5")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(41, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(41, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.6")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(42, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(42, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.7")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(43, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(43, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("hotbar.8")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(44, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(44, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("weapon")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("weapon.mainhand")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
                                        .executes(context -> {
                                            Integer count = context.getArgument("count", Integer.class);
                                            ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(count, false);
                                            replaceItem(36 + MC.player.getInventory().selectedSlot, stack);
                                            return 0;
                                        })
                                )
                        )
                )
                .then(ClientCommandManager.literal("weapon.offhand")
                        .then(ClientCommandManager.argument("item", itemStack(registryAccess))
                                .executes(context -> {
                                    ItemStack stack = context.getArgument("item", ItemStackArgument.class).createStack(1, false);
                                    replaceItem(45, stack);
                                    return 0;
                                })
                                .then(ClientCommandManager.argument("count", integer())
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
                MC.player.sendMessage(Text.translatable("tadditions.count_above_max"), false);
            } else if (stack.getCount() < 1) {
                MC.player.sendMessage(Text.translatable("tadditions.count_below_min"), false);
            } else {
                MC.player.networkHandler.sendPacket(new CreativeInventoryActionC2SPacket(slot, stack));
                MC.player.sendMessage(Text.translatable("tadditions.replaceitem.success"), false);
            }
        } else {
            MC.player.sendMessage(Text.translatable("tadditions.error.creative"), false);
        }
    }
}