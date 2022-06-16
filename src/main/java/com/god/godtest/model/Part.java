package com.god.godtest.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Part {
    private String inventoryNumber;
    private String name;
    private int count;

    Part(String inventoryNumber, String name, int count) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.count = count;
    }

    Part(JsonNode node) {
        this.inventoryNumber = node.has("inventory_number") ? node.get("inventory_number").asText() : null;
        this.name = node.has("name") ? node.get("name").asText() : null;
        this.count = node.has("count") ? node.get("count").asInt() : 0;

    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
