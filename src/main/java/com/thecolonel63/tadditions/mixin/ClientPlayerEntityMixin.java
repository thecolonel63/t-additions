package com.thecolonel63.tadditions.mixin;

import com.thecolonel63.tadditions.config.ModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo ci) {
        if (ModConfig.INSTANCE.replaceGive && MinecraftClient.getInstance().player.isCreative() && (message.startsWith("/give @s ") || message.startsWith("/give @p ") || message.startsWith("/give " + MinecraftClient.getInstance().player.getEntityName()))) {
            assert MinecraftClient.getInstance().player != null;
            int cutLength;
            if (message.startsWith("/give @s ") || message.startsWith("/give @p ")) {
                cutLength = 9;
            } else {
                cutLength = MinecraftClient.getInstance().player.getEntityName().length() + 7;
            }
            ci.cancel();
            String messageModded = "/tgive " + message.substring(cutLength);
            System.out.println(messageModded);
            System.out.println(MinecraftClient.getInstance().player.getEntityName().length());
            MinecraftClient.getInstance().player.sendChatMessage(messageModded);
        }
    }
}
