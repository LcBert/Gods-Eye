package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String dimension = event.getEntity().level().dimension().location().toString();

        String playerName = event.getEntity().getName().getString();

        List<String> playerPos = List.of(
                String.format("%.2f", event.getEntity().getX()),
                String.format("%.2f", event.getEntity().getY()),
                String.format("%.2f", event.getEntity().getZ()));

        List<String> playerRotation = List.of(
                String.format("%.2f", event.getEntity().getRotationVector().x),
                String.format("%.2f", event.getEntity().getRotationVector().y));

        String entityType = event.getTarget().getType().toString();

        List<String> entityPos = List.of(
                String.format("%.2f", event.getTarget().getX()),
                String.format("%.2f", event.getTarget().getY()),
                String.format("%.2f", event.getTarget().getZ()));

        System.out.println("=== Attack Entity Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(entityType);
        System.out.println(entityPos);
        System.out.println("===========================");
    }
}
