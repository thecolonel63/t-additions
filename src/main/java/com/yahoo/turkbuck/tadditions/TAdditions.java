package com.yahoo.turkbuck.tadditions;

import com.mojang.brigadier.CommandDispatcher;
import com.yahoo.turkbuck.tadditions.command.*;
import com.yahoo.turkbuck.tadditions.command.helpers.CommandManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.realms.dto.PlayerInfo;
import net.minecraft.server.command.ServerCommandSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

public class TAdditions implements ModInitializer {

    @Override
    public void onInitialize() {
    }

    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        CommandManager.clearClientSideCommands();
        tgivecommand.register(dispatcher);
        tmodifycommand.register(dispatcher);
        treplaceitemcommand.register(dispatcher);
//        tuuidcommand.register(dispatcher);
    }
}