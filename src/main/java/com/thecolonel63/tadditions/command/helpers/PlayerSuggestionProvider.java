package com.thecolonel63.tadditions.command.helpers;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;

import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

public class PlayerSuggestionProvider implements SuggestionProvider<FabricClientCommandSource> {

    public CompletableFuture<Suggestions> getSuggestions(CommandContext<FabricClientCommandSource> context, SuggestionsBuilder builder) {
        MinecraftClient MC = MinecraftClient.getInstance();
        Iterator var = MC.getNetworkHandler().getPlayerList().iterator();
        while (var.hasNext()) {
            PlayerListEntry playerListEntry = (PlayerListEntry) var.next();
            builder.suggest(playerListEntry.getProfile().getName());
        }
        return builder.buildFuture();
    }
}
