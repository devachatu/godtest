package com.god.godtest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Repair extends WorkOrder {
    private Date analysisDate;
    private String responsiblePerson;
    private Date testDate;

    Repair(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts, Date analysisDate, String responsiblePerson, Date testDate) {
        super(type, department, startDate, endDate, currency, cost, parts);
        this.analysisDate = analysisDate;
        this.responsiblePerson = responsiblePerson;
        this.testDate = testDate;
    }

    public Repair(JsonNode data) {
        super(data);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.analysisDate = data.has("analysis_date") ? formatter.parse(data.get("analysis_date").asText()) : null;
            this.testDate = data.has("test_date") ? formatter.parse(data.get("test_date").asText()) : null;
        } catch (ParseException e) {

        }

        this.responsiblePerson = data.has("responsible_person") ? data.get("responsible_person").asText() : null;
    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
