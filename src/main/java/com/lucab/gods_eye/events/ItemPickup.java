package com.lucab.gods_eye.events;

import java.util.List;

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

        if (event.getPlayer().level().isClientSide())
            return;

        EventRecord record = new EventRecord("ItemDrop");
        record.Dimension(event.getPlayer().level().dimension().location().toString())
                .PlayerName(event.getPlayer().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getPlayer().getX()),
                        String.format("%.2f", event.getPlayer().getY()),
                        String.format("%.2f", event.getPlayer().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getPlayer().getRotationVector().x),
                        String.format("%.2f", event.getPlayer().getRotationVector().y)))
                .ItemType(event.getOriginalStack().getItem().toString())
                .ItemPos(List.of(
                        String.format("%.2f", event.getItemEntity().getX()),
                        String.format("%.2f", event.getItemEntity().getY()),
                        String.format("%.2f", event.getItemEntity().getZ())));

        System.out.println(record.toString());
    }
}
