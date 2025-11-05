package com.lucab.gods_eye.events;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class AttackEntity {
    @SubscribeEvent
    public static void onPlayerKill(AttackEntityEvent event) {
        if (event.getEntity().level().isClientSide())
            return;

        String dimension = event.getEntity().level().dimensionType().toString();

        String playerPos = String.format("%.2f/%.2f/%.2f",
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ());

        String playerRotation = String.format("%s,%s",
                String.valueOf(event.getEntity().getRotationVector().x),
                String.valueOf(event.getEntity().getRotationVector().y));

        String entityType = event.getTarget().getType().toString();

        String entityPos = String.format("%.2f/%.2f/%.2f",
                event.getTarget().getX(),
                event.getTarget().getY(),
                event.getTarget().getZ());

        System.out.println("=== Attack Entity Event ===");
        System.out.println(dimension);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(entityType);
        System.out.println(entityPos);
        System.out.println("===========================");
    }
}
