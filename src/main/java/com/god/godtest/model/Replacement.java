package com.god.godtest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Replacement.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class Replacement extends WorkOrder {
    private String factoryName;
    private String factoryOrderNumber;

    /**
     * Constructor to create a Replacement.
     * 
     * @param type               The Work order type.
     * @param department         The Work order department.
     * @param startDate          The Work order startDate.
     * @param endDate            The Work order endDate.
     * @param currency           The Work order currency.
     * @param cost               The Work order cost.
     * @param parts              The Work order parts.
     * @param factoryName        The Replacement Factory Name.
     * @param factoryOrderNumber The Replacement Factory Order Number.
     */
    Replacement(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts, String factoryName, String factoryOrderNumber) {
        super(type, department, startDate, endDate, currency, cost, parts);
        this.factoryName = factoryName;
        this.factoryOrderNumber = factoryOrderNumber;
    }

    /**
     * Creates an Replacement with the Json Node.
     * 
     * @param jsonNode The Json Value of Replacement.
     */
    public Replacement(JsonNode node) {
        super(node);
        this.factoryName = node.has("factory_name") ? node.get("factory_name").asText() : null;
        this.factoryOrderNumber = node.has("factory_order_number") ? node.get("factory_order_number").asText() : null;
    }

    /**
     * Gets the Factory Name.
     * 
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * Sets the Factory Name.
     * 
     * @param factoryName A String containing the factoryName.
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    /**
     * Gets the Factory Order Number.
     * 
     */
    public String getFactoryOrderNumber() {
        return factoryOrderNumber;
    }

    /**
     * Sets the Factory Order Number.
     * 
     * @param factoryOrderNumber A String containing the factoryOrderNumber.
     */
    public void setFactoryOrderNumber(String factoryOrderNumber) {
        this.factoryOrderNumber = factoryOrderNumber;
    }

}
