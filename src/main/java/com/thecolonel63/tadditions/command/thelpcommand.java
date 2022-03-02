package com.thecolonel63.tadditions.command;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.arguments.StringArgumentType.string;

public class thelpcommand {
    public static void register() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("thelp")
                .executes(context -> {
                    for (int i = 0; i < Commands.listCommands().length; i++) {
                        MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp." + Commands.listCommands()[i]), false);
                    }
                    return 0;
                })
                .then(ClientCommandManager.argument("command", string())
                        .suggests(new Commands())
                        .executes(context -> {
                            String command = context.getArgument("command", String.class);
                            for (int i = 0; i < Commands.listCommands().length; i++) {
                                if (command.equals(Commands.listCommands()[i])) {
                                    for (int a = 0; a < Commands.commandsWithExtendedDescriptionCount().length; a++) {
                                        if (Commands.commandsWithExtendedDescriptionCount()[a].split(" ")[0].equals(command)) {
                                            MinecraftClient.getInstance().player.sendMessage(Text.of("\n"), false);
                                            MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp." + command + ".description"), false);
                                            MinecraftClient.getInstance().player.sendMessage(Text.of("\n"), false);
                                            for (int b = 0; b < Integer.parseInt(Commands.commandsWithExtendedDescriptionCount()[a].split(" ")[1]); b++) {
                                                MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp." + command + ".extended." + (b + 1)), false);
                                            }
                                            return 0;
                                        }
                                    }
                                    MinecraftClient.getInstance().player.sendMessage(Text.of("\n"), false);
                                    MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp." + command + ".description"), false);
                                    MinecraftClient.getInstance().player.sendMessage(Text.of("\n"), false);
                                    MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp." + command), false);
                                    return 0;
                                }
                            }
                            MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.thelp.command_not_found"), false);
                            return 0;
                        })
                )
        );
    }
}
