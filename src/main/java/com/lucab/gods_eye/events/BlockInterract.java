package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class BlockInterract {
    @SubscribeEvent
    public static void blockPlaced(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide())
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

        List<String> blockPos = List.of(
                String.format("%d", event.getPos().getX()),
                String.format("%d", event.getPos().getY()),
                String.format("%d", event.getPos().getZ()));

        String block = event.getLevel().getBlockState(event.getPos()).getBlock().getDescriptionId();

        String interractItem = event.getItemStack().getItem().toString();

        System.out.println("=== Block Interract Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(blockPos);
        System.out.println(block);
        System.out.println(interractItem);
        System.out.println("=============================");
    }
}
