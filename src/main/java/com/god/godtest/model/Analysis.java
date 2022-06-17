package com.god.godtest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents an Analysis.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class Analysis extends WorkOrder {

    Analysis(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts) {
        super(type, department, startDate, endDate, currency, cost, parts);
    }

    /**
     * Creates an Analysis with the Json Node.
     * 
     * @param jsonNode The Json Value of Analysis.
     */
    public Analysis(JsonNode node) {
        super(node);
    }

}
