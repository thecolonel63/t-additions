package com.yahoo.turkbuck.tadditions.command;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;

import java.util.concurrent.CompletableFuture;

public class Commands implements SuggestionProvider<FabricClientCommandSource> {
    public static void registerCommands() {
        tgivecommand.register();
        thelpcommand.register();
        tmodifycommand.register();
        treplaceitemcommand.register();
        tuuidcommand.register();
    }

    public static String[] listCommands() {
        return new String[]{
                "tgive",
                "thelp",
                "tmodify",
                "treplaceitem",
                "tuuid"
        };
    }

    public static String[] commandsWithExtendedDescriptionCount() {
        return new String[]{
                "tuuid 2"
        };
    }

    public CompletableFuture<Suggestions> getSuggestions(CommandContext<FabricClientCommandSource> context, SuggestionsBuilder builder) {
        for (int i = 0; i < listCommands().length; i++) {
            builder.suggest(listCommands()[i]);
        }
        return builder.buildFuture();
    }

}
