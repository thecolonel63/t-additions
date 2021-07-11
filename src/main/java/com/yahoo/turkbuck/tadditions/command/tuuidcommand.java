package com.yahoo.turkbuck.tadditions.command;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.yahoo.turkbuck.tadditions.command.helpers.CommandManager.addClientSideCommand;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class tuuidcommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        addClientSideCommand("tuuid");
        dispatcher.register(literal("tuuid").then(argument("name", string()).executes(context -> {
            String name = context.getArgument("name", String.class);
            MinecraftClient MC = MinecraftClient.getInstance();
            URL url = null;
            try {
                url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
                String response = URLReader(url, Charset.defaultCharset());
                if(!response.isBlank() && !response.isEmpty()) {
                    JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
                    MC.player.sendMessage(Text.of("<Debug> " + jsonObject.get("id").getAsString()), false);
                } else {
                    MC.player.sendMessage(Text.of("<Debug> Invalid Name!"), false);
                }
            } catch (MalformedURLException e) {
                MC.player.sendMessage(Text.of("<Debug> MalformedURLException!"), false);
            }
            return 0;
        })));
    }

    private static String URLReader(URL url, Charset encoding) {
        try (InputStream in = url.openStream()) {
            byte[] bytes = in.readAllBytes();
            return new String(bytes, encoding);
        } catch (IOException e) {
            return "<Debug> IOException in URLReader!";
        }
    }

}
