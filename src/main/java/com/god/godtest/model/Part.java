package com.god.godtest.model;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Part.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class Part {
    private String inventoryNumber;
    private String name;
    private int count;

    /**
     * Constructor to create a Part.
     * 
     * @param inventoryNumber The Part inventory number.
     * @param name            The Part name.
     * @param count           The Part count.
     */
    Part(String inventoryNumber, String name, int count) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.count = count;
    }

    /**
     * Creates an Part with the Json Node.
     * 
     * @param jsonNode The Json Value of Analysis.
     */
    Part(JsonNode node) {
        this.inventoryNumber = node.has("inventory_number") ? node.get("inventory_number").asText() : null;
        this.name = node.has("name") ? node.get("name").asText() : null;
        this.count = node.has("count") ? node.get("count").asInt() : 0;

    }

    /**
     * Gets the Part Inventory Number.
     * 
     */
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    /**
     * Sets the Part Inventory Number.
     * 
     * @param inventoryNumber A String value containing the inventoryNumber.
     */
    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    /**
     * Gets the Part Name.
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Part Name.
     * 
     * @param name A String value containing the part name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Part Count.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the Part Count.
     * 
     * @param count An int value containing the part count.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
