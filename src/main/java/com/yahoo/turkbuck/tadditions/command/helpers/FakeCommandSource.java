package com.yahoo.turkbuck.tadditions.command.helpers;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Collection;
import java.util.stream.Collectors;

//Copied from clientcommands and slightly modified. Thank you for writing such brilliant code, Earthcomputer!

public class FakeCommandSource extends ServerCommandSource {
    public FakeCommandSource(ClientPlayerEntity player) {
        super(player, player.getPos(), player.getRotationClient(), null, 0, player.getEntityName(), player.getName(), null, player);
    }

    @Override
    public Collection<String> getPlayerNames() {
        return MinecraftClient.getInstance().getNetworkHandler().getPlayerList()
                .stream().map(e -> e.getProfile().getName()).collect(Collectors.toList());
    }
}
