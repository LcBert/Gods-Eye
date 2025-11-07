package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class ItemPickup {
    @SubscribeEvent
    public static void onItemPickup(ItemEntityPickupEvent.Post event) {
        if (event.getPlayer().level().isClientSide())
            return;

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String dimension = event.getPlayer().level().dimension().location().toString();

        String playerName = event.getPlayer().getName().getString();

        String playerPos = String.format("%.2f/%.2f/%.2f",
                event.getPlayer().getX(),
                event.getPlayer().getY(),
                event.getPlayer().getZ());

        String playerRotation = String.format("%s,%s",
                String.valueOf(event.getPlayer().getRotationVector().x),
                String.valueOf(event.getPlayer().getRotationVector().y));

        String itemType = event.getOriginalStack().getItem().toString();

        String itemPos = String.format("%.2f/%.2f/%.2f",
                event.getItemEntity().getX(),
                event.getItemEntity().getY(),
                event.getItemEntity().getZ());

        System.out.println("=== Item Pickup Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(itemType);
        System.out.println(itemPos);
        System.out.println("=========================");
    }
}
