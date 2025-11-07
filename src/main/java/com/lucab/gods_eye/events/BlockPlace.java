package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class BlockPlace {
    @SubscribeEvent
    public static void blockPlaced(BlockEvent.EntityPlaceEvent event) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String dimension = event.getEntity().level().dimension().location().toString();

        String playerName = event.getEntity().getName().getString();

        List<String> playerPos = List.of(
                String.format("%.2f", event.getEntity().getX()),
                String.format("%.2f", event.getEntity().getY()),
                String.format("%.2f", event.getEntity().getZ()));

        List<String> playerRotation = List.of(
                String.valueOf(event.getEntity().getRotationVector().x),
                String.valueOf(event.getEntity().getRotationVector().y));

        List<String> blockPos = List.of(
                String.format("%.2f", (double) event.getPos().getX()),
                String.format("%.2f", (double) event.getPos().getY()),
                String.format("%.2f", (double) event.getPos().getZ()));

        String block = event.getState().getBlock().getDescriptionId();

        System.out.println("=== Block Place Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(blockPos);
        System.out.println(block);
        System.out.println("=========================");
    }
}
