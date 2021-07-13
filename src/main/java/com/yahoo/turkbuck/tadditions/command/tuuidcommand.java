package com.yahoo.turkbuck.tadditions.command;

import com.yahoo.turkbuck.tadditions.command.helpers.PlayerSuggestionProvider;
import com.yahoo.turkbuck.tadditions.command.helpers.UUIDExampleProvider;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.Iterator;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.yahoo.turkbuck.tadditions.command.helpers.StringHelper.isHexadecimalUUID;
import static com.yahoo.turkbuck.tadditions.command.helpers.StringHelper.isIntArrayUUID;

public class tuuidcommand {

    public static void register() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("tuuid")
                .then(ClientCommandManager.literal("get")
                        .then(ClientCommandManager.argument("name", string())
                                .suggests(new PlayerSuggestionProvider())
                                .executes(context -> {
                                            String name = context.getArgument("name", String.class);

                                            MinecraftClient MC = MinecraftClient.getInstance();

                                            Iterator var = MC.getNetworkHandler().getPlayerList().iterator();

                                            Integer matchedPlayer = 0;

                                            while (var.hasNext()) {
                                                PlayerListEntry playerListEntry = (PlayerListEntry) var.next();
                                                if (playerListEntry.getProfile().getName().equals(name)) {
                                                    String FoundUUID = playerListEntry.getProfile().getId().toString();
                                                    String FoundUUIDNoDashes = FoundUUID.replace("-", "");
                                                    String IntArrayUUID = "[I;";

                                                    for (int i = 0; i < 4; i++) {
                                                        String SubUUID = FoundUUIDNoDashes.substring(i * 8, ((i + 1) * 8));
                                                        long ParsedLong = Long.parseLong(SubUUID, 16);
                                                        int ParsedInt = (int) ParsedLong;
                                                        if (i < 3) {
                                                            IntArrayUUID = IntArrayUUID + ParsedInt + ",";
                                                        } else {
                                                            IntArrayUUID = IntArrayUUID + ParsedInt + "]";
                                                        }
                                                    }
                                                    MC.player.sendMessage(Text.Serializer.fromJson("{\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"" + FoundUUID + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"translate\":\"tadditions.tuuid.hover_event\"}},\"text\":\"Hexadecimal:\n" + FoundUUID + "\"}"), false);
                                                    MC.player.sendMessage(Text.Serializer.fromJson("{\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"" + IntArrayUUID + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"translate\":\"tadditions.tuuid.hover_event\"}},\"text\":\"\nInt-array:\n" + IntArrayUUID + "\"}"), false);
                                                    matchedPlayer++;
                                                }
                                            }
                                            if (matchedPlayer == 0) {
                                                MC.player.sendMessage(new TranslatableText("tadditions.tuuid.no_player_found"), false);
                                            }
                                            return 0;
                                        }
                                )
                        )
                )
                .then(ClientCommandManager.literal("convert")
                        .then(ClientCommandManager.argument("UUID", greedyString())
                                .suggests(new UUIDExampleProvider())
                                .executes(context -> {
                                            MinecraftClient MC = MinecraftClient.getInstance();
                                            String UUID = context.getArgument("UUID", String.class);
                                            if (isHexadecimalUUID(UUID)) {
                                                String UUIDTrimmed = UUID.replace("-", "");
                                                String IntArrayUUID = "[I;";
                                                for (int i = 0; i < 4; i++) {
                                                    String SubUUID = UUIDTrimmed.substring(i * 8, ((i + 1) * 8));
                                                    long ParsedLong = Long.parseLong(SubUUID, 16);
                                                    int ParsedInt = (int) ParsedLong;
                                                    if (i < 3) {
                                                        IntArrayUUID = IntArrayUUID + ParsedInt + ",";
                                                    } else {
                                                        IntArrayUUID = IntArrayUUID + ParsedInt + "]";
                                                    }
                                                }
                                                MC.player.sendMessage(new TranslatableText("tadditions.tuuid.convert.int_equivalent"), false);
                                                MC.player.sendMessage(Text.Serializer.fromJson("{\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"" + IntArrayUUID + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"translate\":\"tadditions.tuuid.hover_event\"}},\"text\":\"\n" + IntArrayUUID + "\"}"), false);
                                            } else if (isIntArrayUUID(UUID)) {
                                                System.out.println();
                                                String[] parts = UUID.substring(3, UUID.length() - 1).split(",");
                                                String HexadecimalUUIDTrimmed = "";
                                                for (int i = 0; i < 4; i++) {
                                                    String hexString = Integer.toHexString(Integer.parseInt(parts[i]));
                                                    String addToHexUUID = String.format("%1$8s", hexString).replace(' ', '0');
                                                    HexadecimalUUIDTrimmed = HexadecimalUUIDTrimmed + addToHexUUID;
                                                }
                                                String HexadecimalUUID = HexadecimalUUIDTrimmed.substring(0, 8) + "-" + HexadecimalUUIDTrimmed.substring(8, 12) + "-" + HexadecimalUUIDTrimmed.substring(12, 16) + "-" + HexadecimalUUIDTrimmed.substring(16, 20) + "-" + HexadecimalUUIDTrimmed.substring(20, 32);
                                                MC.player.sendMessage(new TranslatableText("tadditions.tuuid.convert.hex_equivalent"), false);
                                                MC.player.sendMessage(Text.Serializer.fromJson("{\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"" + HexadecimalUUID + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"translate\":\"tadditions.tuuid.hover_event\"}},\"text\":\"\n" + HexadecimalUUID + "\"}"), false);
                                            } else {
                                                MC.player.sendMessage(new TranslatableText("tadditions.tuuid.convert.invalid"), false);
                                            }
                                            return 0;
                                        }
                                )
                        )
                )
        );
    }
}
