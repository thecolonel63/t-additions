package com.thecolonel63.tadditions.command;

import ca.weblite.objc.Client;
import com.google.gson.JsonObject;
import com.thecolonel63.tadditions.command.helpers.InternetHelper;
import com.thecolonel63.tadditions.command.helpers.OnlyLongUUIDExampleProvider;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.io.IOException;
import java.util.UUID;

public class tgetplayercommand {
    public static void register() {
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("tgetplayer")
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
                                        MC.player.sendMessage(new TranslatableText("tadditions.tgetplayer.player_linked", UUID, name), false);
                                    } else if(object != null && object.has("errorMessage")) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.tgetplayer.no_player_linked", UUID), false);
                                    } else if(object == null) {
                                        MC.player.sendMessage(new TranslatableText("tadditions.tgetplayer.no_player_linked", UUID), false);
                                    }
                                } catch (IOException e) {
                                    MC.player.sendMessage(new TranslatableText("tadditions.failed_to_connect_to_internet"), false);
                                }
                            });
                            fetchingThread.start();
                            return 0;
                        })
                )
        );
    }
}
