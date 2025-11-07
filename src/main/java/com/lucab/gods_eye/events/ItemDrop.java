package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class ItemDrop {
    @SubscribeEvent
    public static void onItemDrop(ItemTossEvent event) {
        if (event.getPlayer().level().isClientSide())
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

        String itemType = event.getEntity().getItem().toString();

        System.out.println("=== Item Pickup Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(itemType);
        System.out.println("=========================");
    }
}
