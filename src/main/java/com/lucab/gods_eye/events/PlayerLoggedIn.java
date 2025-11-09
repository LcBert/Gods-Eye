package com.lucab.gods_eye.events;

import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class PlayerLoggedIn {
    @SubscribeEvent
    public static void onPlayerLogin(PlayerLoggedInEvent event) {
        if (event.getEntity().level().isClientSide())
            return;

        EventRecord record = new EventRecord("PlayerLoggedIn");
        record.Dimension(event.getEntity().level().dimension().location().toString())
                .PlayerName(event.getEntity().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getEntity().getX()),
                        String.format("%.2f", event.getEntity().getY()),
                        String.format("%.2f", event.getEntity().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getEntity().getRotationVector().x),
                        String.format("%.2f", event.getEntity().getRotationVector().y)));
                        
        System.out.println(record.toString());
    }
}
