package com.lucab.gods_eye.events;

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

        EventRecord record = new EventRecord("ChatMessage");
        record.Dimension(event.getPlayer().level().dimension().location().toString())
                .PlayerName(event.getPlayer().getName().getString())
                .PlayerPos(List.of(
                        String.format("%.2f", event.getPlayer().getX()),
                        String.format("%.2f", event.getPlayer().getY()),
                        String.format("%.2f", event.getPlayer().getZ())))
                .PlayerRotation(List.of(
                        String.format("%.2f", event.getPlayer().getRotationVector().x),
                        String.format("%.2f", event.getPlayer().getRotationVector().y)))
                .Message(event.getMessage().getString());

        System.out.println(record.toString());
    }
}
