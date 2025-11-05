package com.lucab.gods_eye.events;

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

        String dimension = event.getPlayer().level().dimensionType().toString();

        String playerPos = String.format("%.2f/%.2f/%.2f",
                event.getPlayer().getX(),
                event.getPlayer().getY(),
                event.getPlayer().getZ());

        String playerRotation = String.format("%s,%s",
                String.valueOf(event.getPlayer().getRotationVector().x),
                String.valueOf(event.getPlayer().getRotationVector().y));

        String itemType = event.getEntity().getItem().toString();

        String itemPos = String.format("%.2f/%.2f/%.2f",
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ());

        System.out.println("=== Item Pickup Event ===");
        System.out.println(dimension);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(itemType);
        System.out.println(itemPos);
        System.out.println("=========================");
    }
}
