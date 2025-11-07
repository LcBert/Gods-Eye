package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.lucab.gods_eye.Utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;

@EventBusSubscriber(modid = Utils.MOD_ID)
public class SendChat {
    @SubscribeEvent
    public static void sendChat(ServerChatEvent event) {
        if (event.getPlayer().level().isClientSide())
            return;

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));

        String message = event.getMessage().getString();

        String playerName = event.getPlayer().getName().getString();

        List<String> playerPos = List.of(
                String.format("%.2f", event.getPlayer().getX()),
                String.format("%.2f", event.getPlayer().getY()),
                String.format("%.2f", event.getPlayer().getZ()));

        System.out.println("=== Chat Event ===");
        System.out.println(dateTime);
        System.out.println(message);
        System.out.println(playerName);
        System.out.println(playerPos);
        System.out.println("===================");
    }
}
