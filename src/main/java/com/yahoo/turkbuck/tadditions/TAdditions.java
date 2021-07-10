package com.yahoo.turkbuck.tadditions;

import com.mojang.brigadier.CommandDispatcher;
import com.yahoo.turkbuck.tadditions.command.*;
import com.yahoo.turkbuck.tadditions.command.helpers.CommandManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.command.ServerCommandSource;

public class TAdditions implements ModInitializer {

    @Override
    public void onInitialize() {
    }

    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        CommandManager.clearClientSideCommands();
//        tspectpcommand.register(dispatcher);
        tgivecommand.register(dispatcher);
        tmodifycommand.register(dispatcher);
        treplaceitemcommand.register(dispatcher);
        tuuidcommand.register(dispatcher);
    }

    public static boolean isUUID(String s) {
        if (s.length() == 36) {
            if (s.substring(8, 9).contains("-") && s.substring(13, 14).contains("-") && s.substring(18, 19).contains("-") && s.substring(23, 24).contains("-")) {
                String part1 = s.substring(0, 7);
                String part2 = s.substring(9, 12);
                String part3 = s.substring(14, 17);
                String part4 = s.substring(19, 22);
                String part5 = s.substring(24, 36);
                String dashesRemoved = part1+part2+part3+part4+part5;
                if (dashesRemoved.matches("-?[0-9a-f]+")) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }
}