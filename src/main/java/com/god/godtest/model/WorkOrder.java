package com.god.godtest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Work Order.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class WorkOrder {
    private WorkOrderType type;
    private String department;
    private Date startDate;
    private Date endDate;
    private String currency;
    private double cost;
    private List<Part> parts;

    /**
     * Constructor to create a Work Order.
     * 
     * @param type       The Work order type.
     * @param department The Work order department.
     * @param startDate  The Work order startDate.
     * @param endDate    The Work order endDate.
     * @param currency   The Work order currency.
     * @param cost       The Work order cost.
     * @param parts      The Work order parts.
     */
    WorkOrder(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts) {
        this.type = type;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.cost = cost;
        this.parts = parts;
    }

    /**
     * Creates a Work Order with the Json Node.
     * 
     * @param jsonNode The Json Value of JsonNode.
     */
    public WorkOrder(JsonNode data) {
        for (WorkOrderType item : EnumSet.allOf(WorkOrderType.class)) {
            if (item.toString().equals(data.get("type").asText())) {
                this.type = item;
                break;
            }
        }
        this.department = data.has("department") ? data.get("department").asText() : null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.startDate = data.has("start_date") ? formatter.parse(data.get("start_date").asText()) : null;
            this.endDate = data.has("end_date") ? formatter.parse(data.get("end_date").asText()) : null;
        } catch (ParseException e) {

        }

        this.currency = data.has("currency") ? data.get("currency").asText() : null;
        this.cost = data.has("cost") ? data.get("cost").asDouble() : null;

        this.parts = new ArrayList<Part>();

        for (JsonNode jsonNode : data.get("parts")) {
            this.parts.add(new Part(jsonNode));
        }

    }

    /**
     * Gets the WorkOrder type.
     * 
     */
    public WorkOrderType getType() {
        return type;
    }

    /**
     * Sets the Work Order type.
     * 
     * @param type An Enum Value containing the type.
     */
    public void setType(WorkOrderType type) {
        this.type = type;
    }

    /**
     * Gets the WorkOrder department.
     * 
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the Work Order department.
     * 
     * @param department A String containing the department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the WorkOrder startDate.
     * 
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the WorkOrder start date.
     * 
     * @param startDate A Date containing the startDate.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the WorkOrder endDate.
     * 
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the WorkOrder end date.
     * 
     * @param endDate A Date containing the endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the WorkOrder currency.
     * 
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the WorkOrder currency.
     * 
     * @param currency A String containing the currency.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the WorkOrder cost.
     * 
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the Work Order cost.
     * 
     * @param cost A double containing the cost.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the WorkOrder parts.
     * 
     */
    public List<Part> getParts() {
        return parts;
    }

    /**
     * Sets the Work Order parts.
     * 
     * @param parts A list containing the parts.
     */
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}
