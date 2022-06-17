package com.god.godtest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Represents a Verification.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
@Entity
@Table(name = "verification")
public class Verification implements Serializable {

    /**
     * Constructor to create a Verification.
     * 
     * @param type        The Verification type.
     * @param requestDate The Verification requestDate.
     * @param department  The Verification department.
     * @param status      The Verification status.
     */
    public Verification(String type, Date requestDate, String department, String status) {
        this.type = type;
        this.requestDate = requestDate;
        this.department = department;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "department")
    private String department;

    @Column(name = "status")
    private String status;

    @Transient
    private List<String> errors;

    /**
     * Gets the VerificationId.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Verification ID.
     * 
     * @param id An integer containing the id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Verification type.
     * 
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Verification Type.
     * 
     * @param type A String containing the type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Order department.
     * 
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the Verification Department.
     * 
     * @param department A String containing the department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the WorkOrder Date.
     * 
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the WorkOrder Date.
     * 
     * @param requestDate A Date containing the requestDate.
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Gets the Verification Status.
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the Verification Status.
     * 
     * @param status A String containing the status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the Verification Errors.
     * 
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Sets the Verification Errors.
     * 
     * @param errors A List containing the errors.
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
