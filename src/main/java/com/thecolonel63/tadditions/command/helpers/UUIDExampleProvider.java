package com.thecolonel63.tadditions.command.helpers;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import java.util.concurrent.CompletableFuture;

public class UUIDExampleProvider implements SuggestionProvider<FabricClientCommandSource> {
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<FabricClientCommandSource> context, SuggestionsBuilder builder) {
        builder.suggest("4cb7908d-eec3-41de-92da-7320a127bfcd");
        builder.suggest("4cb7908deec341de92da7320a127bfcd");
        builder.suggest("[I;1287098509,-289193506,-1831177440,-1591230515]");
        return builder.buildFuture();
    }
}
