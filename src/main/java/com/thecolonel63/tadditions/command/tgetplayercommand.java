package com.thecolonel63.tadditions.command;

import ca.weblite.objc.Client;
import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.thecolonel63.tadditions.command.helpers.InternetHelper;
import com.thecolonel63.tadditions.command.helpers.OnlyLongUUIDExampleProvider;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.text.Text;

import java.io.IOException;
import java.util.UUID;

public class tgetplayercommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("tgetplayer")
                .then(ClientCommandManager.argument("UUID", UuidArgumentType.uuid())
                        .suggests(new OnlyLongUUIDExampleProvider())
                        .executes(context -> {
                            MinecraftClient MC = MinecraftClient.getInstance();
                            String UUID = context.getArgument("UUID", UUID.class).toString();
                            Thread fetchingThread = new Thread(() -> {
                                try {
                                    JsonObject object = InternetHelper.getJsonFromUrl("https://sessionserver.mojang.com/session/minecraft/profile/"+UUID);
                                    if(object != null && object.has("name")) {
                                        String name = object.get("name").getAsString();
                                        MC.player.sendMessage(Text.translatable("tadditions.tgetplayer.player_linked", UUID, name), false);
                                    } else if(object != null && object.has("errorMessage")) {
                                        MC.player.sendMessage(Text.translatable("tadditions.tgetplayer.no_player_linked", UUID), false);
                                    } else if(object == null) {
                                        MC.player.sendMessage(Text.translatable("tadditions.tgetplayer.no_player_linked", UUID), false);
                                    }
                                } catch (IOException e) {
                                    MC.player.sendMessage(Text.translatable("tadditions.failed_to_connect_to_internet"), false);
                                }
                            });
                            fetchingThread.start();
                            return 0;
                        })
                )
        );
    }
}
