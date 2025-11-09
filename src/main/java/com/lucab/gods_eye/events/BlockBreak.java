package com.lucab.gods_eye.events;

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

        EventRecord record = new EventRecord("BlockBreak");
        record.Dimension(event.getPlayer().level().dimension().location().toString())
                .PlayerName(event.getPlayer().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getPlayer().getX()),
                        String.format("%.2f", event.getPlayer().getY()),
                        String.format("%.2f", event.getPlayer().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getPlayer().getRotationVector().x),
                        String.format("%.2f", event.getPlayer().getRotationVector().y)))
                .BlockType(event.getState().getBlock().getDescriptionId())
                .BlockPos(List.of(
                        String.format("%d", event.getPos().getX()),
                        String.format("%d", event.getPos().getY()),
                        String.format("%d", event.getPos().getZ())));

        System.out.println(record.toString());
    }
}
