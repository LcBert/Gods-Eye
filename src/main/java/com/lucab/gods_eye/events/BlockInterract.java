package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        String playerPos = String.format("%.2f/%.2f/%.2f",
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ());

        String playerRotation = String.format("%s,%s",
                String.valueOf(event.getEntity().getRotationVector().x),
                String.valueOf(event.getEntity().getRotationVector().y));

        String blockPos = event.getPos().toString();

        String blockType = event.getLevel().getBlockState(event.getPos()).getBlock().toString();

        String interractItem = event.getItemStack().getItem().toString();

        System.out.println("=== Block Place Event ===");
        System.out.println(dateTime);
        System.out.println(dimension);
        System.out.println(playerPos);
        System.out.println(playerRotation);
        System.out.println(blockPos);
        System.out.println(blockType);
        System.out.println(interractItem);
        System.out.println("=========================");
    }
}
