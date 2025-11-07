package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class BlockBreak {
    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event) {
        if (event.getLevel().isClientSide())
            return;

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String dimension = event.getPlayer().level().dimension().location().toString();

        String playerName = event.getPlayer().getName().getString();

        List<String> playerPos = List.of(
                String.format("%.2f", event.getPlayer().getX()),
                String.format("%.2f", event.getPlayer().getY()),
                String.format("%.2f", event.getPlayer().getZ()));

        List<String> playerRotation = List.of(
                String.format("%.2f", event.getPlayer().getRotationVector().x),
                String.format("%.2f", event.getPlayer().getRotationVector().y));

        List<String> blockPos = List.of(
                String.format("%d", event.getPos().getX()),
                String.format("%d", event.getPos().getY()),
                String.format("%d", event.getPos().getZ()));

        String block = event.getState().getBlock().getDescriptionId();

        System.out.println("=== Block Break Event ===");
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
