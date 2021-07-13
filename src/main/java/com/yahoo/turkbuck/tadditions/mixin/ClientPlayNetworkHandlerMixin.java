package com.yahoo.turkbuck.tadditions.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.yahoo.turkbuck.tadditions.command.Commands;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.s2c.play.CommandTreeS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Shadow
    private CommandDispatcher<CommandSource> commandDispatcher;

    @SuppressWarnings("unchecked")
    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(MinecraftClient client, Screen screen, ClientConnection connection, GameProfile profile, CallbackInfo ci) {
        Commands.registerCommands();
    }

    @SuppressWarnings("unchecked")
    @Inject(method = "onCommandTree", at = @At("TAIL"))
    public void onOnCommandTree(CommandTreeS2CPacket packet, CallbackInfo ci) {
        Commands.registerCommands();
    }

}
