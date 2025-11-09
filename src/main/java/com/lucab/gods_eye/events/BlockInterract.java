package com.lucab.gods_eye.events;

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

        EventRecord record = new EventRecord("BlockInterract");
        record.Dimension(event.getEntity().level().dimension().location().toString())
                .PlayerName(event.getEntity().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getEntity().getX()),
                        String.format("%.2f", event.getEntity().getY()),
                        String.format("%.2f", event.getEntity().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getEntity().getRotationVector().x),
                        String.format("%.2f", event.getEntity().getRotationVector().y)))
                .BlockType(event.getLevel().getBlockState(event.getPos()).getBlock().getDescriptionId())
                .BlockPos(List.of(
                        String.format("%d", event.getPos().getX()),
                        String.format("%d", event.getPos().getY()),
                        String.format("%d", event.getPos().getZ())))
                .InterractItem(event.getItemStack().getItem().toString());

        System.out.println(record.toString());
    }
}
