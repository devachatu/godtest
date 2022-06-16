package com.god.godtest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Analysis extends WorkOrder {

    Analysis(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts) {
        super(type, department, startDate, endDate, currency, cost, parts);
    }

    public Analysis(JsonNode node) {
        super(node);
    }

}
