package com.god.godtest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Replacement extends WorkOrder {
    private String factoryName;
    private String factoryOrderNumber;

    Replacement(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts, String factoryName, String factoryOrderNumber) {
        super(type, department, startDate, endDate, currency, cost, parts);
        this.factoryName = factoryName;
        this.factoryOrderNumber = factoryOrderNumber;
    }

    public Replacement(JsonNode node) {
        super(node);
        this.factoryName = node.has("factory_name") ? node.get("factory_name").asText() : null;
        this.factoryOrderNumber = node.has("factory_order_number") ? node.get("factory_order_number").asText() : null;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryOrderNumber() {
        return factoryOrderNumber;
    }

    public void setFactoryOrderNumber(String factoryOrderNumber) {
        this.factoryOrderNumber = factoryOrderNumber;
    }

}
