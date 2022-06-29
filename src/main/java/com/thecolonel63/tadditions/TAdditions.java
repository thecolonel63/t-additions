package com.thecolonel63.tadditions;

import com.thecolonel63.tadditions.command.Commands;
import com.thecolonel63.tadditions.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class TAdditions implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConfig.init();
        ClientCommandRegistrationCallback.EVENT.register(Commands::registerCommands);
    }
}