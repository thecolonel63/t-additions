package com.thecolonel63.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import java.util.concurrent.CompletableFuture;

public class Commands implements SuggestionProvider<FabricClientCommandSource> {
    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        tgivecommand.register(dispatcher, registryAccess);
        tgetplayercommand.register(dispatcher);
        thelpcommand.register(dispatcher);
        tmodifycommand.register(dispatcher);
        treplaceitemcommand.register(dispatcher, registryAccess);
        tuuidcommand.register(dispatcher);
    }

    public static String[] listCommands() {
        return new String[]{
                "tgetplayer",
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
