package com.yahoo.turkbuck.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import com.yahoo.turkbuck.tadditions.command.helpers.arguments.ClientEntityArgumentType;
import net.minecraft.server.command.ServerCommandSource;

import static com.yahoo.turkbuck.tadditions.command.helpers.CommandManager.addClientSideCommand;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class tuuidcommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        addClientSideCommand("tuuid");
        dispatcher.register(literal("tuuid").then(argument("filter", ClientEntityArgumentType.entity()).executes(context -> {

            return 0;
        })));
    }

}
