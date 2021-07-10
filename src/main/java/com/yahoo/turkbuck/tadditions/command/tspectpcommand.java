package com.yahoo.turkbuck.tadditions.command;

import com.mojang.brigadier.CommandDispatcher;
import com.yahoo.turkbuck.tadditions.TAdditions;
import com.yahoo.turkbuck.tadditions.command.helpers.ClientEntitySelector;
import com.yahoo.turkbuck.tadditions.command.helpers.arguments.ClientEntityArgumentType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.SpectatorTeleportC2SPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import java.util.UUID;

import static com.yahoo.turkbuck.tadditions.command.helpers.CommandManager.addClientSideCommand;
import static com.yahoo.turkbuck.tadditions.command.helpers.arguments.ClientEntityArgumentType.getEntitySelector;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class tspectpcommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        addClientSideCommand("tspectp");
        dispatcher.register(literal("tspectp").then(argument("filter", ClientEntityArgumentType.entity()).executes(context -> {

            int selectorStartingPoint = context.getInput().indexOf(" ");
            String selector = context.getInput().substring(selectorStartingPoint + 1);

            boolean UUIDEntityFound = false;

            Entity uuidEntity = null;

            if(TAdditions.isUUID(selector)) {
                UUID uuidInSelector = UUID.fromString(selector);
                for(Entity entity : MinecraftClient.getInstance().world.getEntities()) {
                    if(entity.getUuid().equals(uuidInSelector)) {
                        UUIDEntityFound = true;
                        uuidEntity = entity;
                    }
                }
            }

            if (!MinecraftClient.getInstance().player.isSpectator()) {
                //Player isn't a spectator.
                MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new TranslatableText("tadditions.error.spectator"));
                return 0;
            } else {
                if (getEntitySelector(context, "filter").getEntities(context.getSource()).isEmpty() && !UUIDEntityFound) {
                    //Entity list is empty and there are no UUID matches, ergo no entities were found.
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new TranslatableText("tadditions.error.noentityfound"));
                    return 0;
                } else {
                    //By this point, the player *is* in spectator, *and* an entity matches.
                    if(UUIDEntityFound) {
                        //The entity found matches the specified UUID
                        MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.success.spectp"), false);
                        MinecraftClient.getInstance().player.networkHandler.sendPacket(new SpectatorTeleportC2SPacket(uuidEntity.getUuid()));
                    } else {
                        //The entity found doesn't match a specified UUID
                        Entity entity = getEntityFromSelector(context.getSource(), getEntitySelector(context, "filter"));
                        MinecraftClient.getInstance().player.sendMessage(new TranslatableText("tadditions.success.spectp"), false);
                        MinecraftClient.getInstance().player.networkHandler.sendPacket(new SpectatorTeleportC2SPacket(entity.getUuid()));
                    }
                }
            }
            return 1;
        })));
    }

    private static Entity getEntityFromSelector(ServerCommandSource source, ClientEntitySelector selector) {
        return selector.getEntities(source).get(0);
    }

}
