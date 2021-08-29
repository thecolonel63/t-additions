package com.yahoo.turkbuck.tadditions;

import com.yahoo.turkbuck.tadditions.command.Commands;
import com.yahoo.turkbuck.tadditions.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class TAdditions implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConfig.init();
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            Commands.registerCommands();
        });
    }
}