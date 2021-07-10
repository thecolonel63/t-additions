package com.yahoo.turkbuck.tadditions.command.helpers;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

//Copied from clientcommands and slightly modified. Thank you for writing such brilliant code, Earthcomputer!

public class ClientEntitySelector {

    private final BiPredicate<Vec3d, Entity> filter;
    private final BiConsumer<Vec3d, List<Entity>> sorter;
    private final int limit;
    private final boolean senderOnly;
    private final Double originX;
    private final Double originY;
    private final Double originZ;

    public ClientEntitySelector(BiPredicate<Vec3d, Entity> filter, BiConsumer<Vec3d, List<Entity>> sorter, int limit, boolean senderOnly, Double originX, Double originY, Double originZ) {
        this.filter = filter;
        this.sorter = sorter;
        this.limit = limit;
        this.senderOnly = senderOnly;
        this.originX = originX;
        this.originY = originY;
        this.originZ = originZ;
    }

    public List<Entity> getEntities(ServerCommandSource source) {
        Vec3d origin = source.getPosition();
        origin = new Vec3d(originX == null ? origin.x : originX, originY == null ? origin.y : originY, originZ == null ? origin.z : originZ);

        if (senderOnly)
            return filter.test(origin, source.getEntity()) ? Collections.singletonList(source.getEntity()) : Collections.emptyList();

        List<Entity> entities = new ArrayList<>();
        for (Entity entity : MinecraftClient.getInstance().world.getEntities()) {
            if (filter.test(origin, entity))
                entities.add(entity);
        }

        sorter.accept(origin, entities);

        return entities.size() <= limit ? entities : entities.subList(0, limit);
    }

    public int getLimit() {
        return limit;
    }
}
