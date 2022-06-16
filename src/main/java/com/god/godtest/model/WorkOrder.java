package com.god.godtest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class WorkOrder {
    private WorkOrderType type;
    private String department;
    private Date startDate;
    private Date endDate;
    private String currency;
    private double cost;
    private List<Part> parts;

    public WorkOrder() {

    }

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

    public WorkOrderType getType() {
        return type;
    }

    public void setType(WorkOrderType type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}
