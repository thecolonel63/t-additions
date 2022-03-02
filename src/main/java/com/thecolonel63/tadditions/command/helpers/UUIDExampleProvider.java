package com.thecolonel63.tadditions.command.helpers;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;

import java.util.concurrent.CompletableFuture;

public class UUIDExampleProvider implements SuggestionProvider<FabricClientCommandSource> {
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<FabricClientCommandSource> context, SuggestionsBuilder builder) {
        builder.suggest("00000001-0000-0002-0000-000300000004");
        builder.suggest("00000005000000060000000700000008");
        builder.suggest("[I;1,2,3,4]");
        return builder.buildFuture();
    }
}
