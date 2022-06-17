package com.god.godtest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents a Repair.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
public class Repair extends WorkOrder {
    private Date analysisDate;
    private String responsiblePerson;
    private Date testDate;

    /**
     * Constructor to create a Repair.
     * 
     * @param type              The Work order type.
     * @param department        The Work order department.
     * @param startDate         The Work order startDate.
     * @param endDate           The Work order endDate.
     * @param currency          The Work order currency.
     * @param cost              The Work order cost.
     * @param parts             The Work order parts.
     * @param analysisDate      The Repair Analysis Date.
     * @param responsiblePerson The Repair Responsible Person.
     * @param testDate          The Repair Test Date.
     */
    Repair(WorkOrderType type, String department, Date startDate, Date endDate, String currency, double cost,
            List<Part> parts, Date analysisDate, String responsiblePerson, Date testDate) {
        super(type, department, startDate, endDate, currency, cost, parts);
        this.analysisDate = analysisDate;
        this.responsiblePerson = responsiblePerson;
        this.testDate = testDate;
    }

    /**
     * Creates an Repair with the Json Node.
     * 
     * @param jsonNode The Json Value of Repair.
     */
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

    /**
     * Gets the Analysis Date.
     * 
     */
    public Date getAnalysisDate() {
        return analysisDate;
    }

    /**
     * Sets the Analysis Date.
     * 
     * @param analysisDate A String containing the analysis Date
     */
    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }

    /**
     * Gets the Responsible Person.
     * 
     */
    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    /**
     * Sets the Responsible Person.
     * 
     * @param responsiblePerson A String containing the responsiblePerson.
     */
    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    /**
     * Gets the Test Date.
     * 
     */
    public Date getTestDate() {
        return testDate;
    }

    /**
     * Sets the Test Date.
     * 
     * @param testDate A Date containing the testDate.
     */
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
