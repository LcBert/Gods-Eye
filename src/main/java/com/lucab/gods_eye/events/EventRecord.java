package com.lucab.gods_eye.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.common.base.MoreObjects;

public class EventRecord {
    // Campi "For all events"
    private String dateTime;
    private String eventType;
    private String dimension;
    private String playerName;
    private List<String> playerPos;
    private List<String> playerRotation;

    // Campi "For Block events" (opzionali)
    private String blockType;
    private List<String> blockPos;
    private String interractItem;

    // Campi "For AttackEntity event" (opzionali)
    private String entityType;
    private List<String> entityPos;

    // Campi "For ItemDrop/ItemPickup events" (opzionali)
    private String itemType;
    private List<String> itemPos;

    // Campi "For sendChat event" (opzionali)
    private String message;

    public EventRecord(
            String eventType) {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));
        this.eventType = eventType;
    }

    // Setters

    public EventRecord Dimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public EventRecord PlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public EventRecord PlayerPos(List<String> playerPos) {
        this.playerPos = playerPos;
        return this;
    }

    public EventRecord PlayerRotation(List<String> playerRotation) {
        this.playerRotation = playerRotation;
        return this;
    }

    public EventRecord BlockType(String blockType) {
        this.blockType = blockType;
        return this;
    }

    public EventRecord BlockPos(List<String> blockPos) {
        this.blockPos = blockPos;
        return this;
    }

    public EventRecord InterractItem(String interractItem) {
        this.interractItem = interractItem;
        return this;
    }

    public EventRecord EntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public EventRecord EntityPos(List<String> entityPos) {
        this.entityPos = entityPos;
        return this;
    }

    public EventRecord ItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public EventRecord ItemPos(List<String> itemPos) {
        this.itemPos = itemPos;
        return this;
    }

    public EventRecord Message(String message) {
        this.message = message;
        return this;
    }

    // Getters

    public String getDateTime() {
        return dateTime;
    }

    public String getEventType() {
        return eventType;
    }

    public String getDimension() {
        return dimension;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<String> getPlayerPos() {
        return playerPos;
    }

    public List<String> getPlayerRotation() {
        return playerRotation;
    }

    public String getBlockType() {
        return blockType;
    }

    public List<String> getBlockPos() {
        return blockPos;
    }

    public String getInterractItem() {
        return interractItem;
    }

    public String getEntityType() {
        return entityType;
    }

    public List<String> getEntityPos() {
        return entityPos;
    }

    public String getItemType() {
        return itemType;
    }

    public List<String> getItemPos() {
        return itemPos;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        // Questo è tutto!
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("\n\teventType", eventType)
                .add("\n\tdateTime", dateTime)
                .add("\n\tdimension", dimension)
                .add("\n\tplayerName", playerName)
                .add("\n\tplayerPos", playerPos)
                .add("\n\tplayerRotation", playerRotation)
                .add("\n\tblockType", blockType)
                .add("\n\tblockPos", blockPos)
                .add("\n\tinterractItem", interractItem)
                .add("\n\tentityType", entityType)
                .add("\n\tentityPos", entityPos)
                .add("\n\titemType", itemType)
                .add("\n\titemPos", itemPos)
                .add("\n\tmessage", message)
                .toString();
    }
}