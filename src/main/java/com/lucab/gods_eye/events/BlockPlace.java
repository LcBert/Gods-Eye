package com.lucab.gods_eye.events;

import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class BlockPlace {
    @SubscribeEvent
    public static void blockPlaced(BlockEvent.EntityPlaceEvent event) {
        if (event.getLevel().isClientSide())
            return;

        EventRecord record = new EventRecord("BlockPlace");
        record.Dimension(event.getEntity().level().dimension().location().toString())
                .PlayerName(event.getEntity().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getEntity().getX()),
                        String.format("%.2f", event.getEntity().getY()),
                        String.format("%.2f", event.getEntity().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getEntity().getRotationVector().x),
                        String.format("%.2f", event.getEntity().getRotationVector().y)))
                .BlockType(event.getState().getBlock().getDescriptionId())
                .BlockPos(List.of(
                        String.format("%d", event.getPos().getX()),
                        String.format("%d", event.getPos().getY()),
                        String.format("%d", event.getPos().getZ())));

        System.out.println(record.toString());
    }
}
