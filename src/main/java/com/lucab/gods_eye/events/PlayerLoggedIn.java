package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class PlayerLoggedIn {
    @SubscribeEvent
    public static void onPlayerLogin(PlayerLoggedInEvent event) {

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String playerName = event.getEntity().getName().getString();

        List<String> playerPos = List.of(
                String.format("%.2f", event.getEntity().getX()),
                String.format("%.2f", event.getEntity().getY()),
                String.format("%.2f", event.getEntity().getZ()));

        System.out.println("=== Player Login Event ===");
        System.out.println(dateTime);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println("=========================");
    }
}
