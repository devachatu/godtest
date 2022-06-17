package com.god.godtest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.god.godtest.model.Analysis;
import com.god.godtest.model.Repair;
import com.god.godtest.model.Replacement;
import com.god.godtest.model.Status;
import com.god.godtest.model.Verification;
import com.god.godtest.model.WorkOrder;
import com.god.godtest.service.VerificationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Represents an RestController to handle verification API endpoints.
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin()
public class VerificationController {

    /**
     * Creates an instance of the verification service bean.
     */
    @Autowired
    VerificationService verificationService;

    /**
     * Endpoint to return the UI for the webpage.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    /**
     * Endpoint to send the WorkOrder to get verified.
     * 
     * @param jsonNode The Json Value of Work Order.
     */
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity<Verification> verifyRequest(@RequestBody JsonNode data) {
        WorkOrder order = new WorkOrder(data);
        Verification verification = new Verification(order.getType().toString(), new Date(), order.getDepartment(),
                Status.VALID.toString());

        List<String> errors = verificationService.verifyRequest(order);
        switch (order.getType()) {
            case ANALYSIS:
                new Analysis(data);
                break;
            case REPLACEMENT:
                errors.addAll(verificationService.verifyReplacement(new Replacement(data)));
                break;
            case REPAIR:
                errors.addAll(verificationService.verifyRepair(new Repair(data)));
                break;
        }

        if (errors.size() > 0) {
            verification.setStatus(Status.NOT_VALID.toString());
            verification.setErrors(errors);
        }

        verificationService.createVerification(verification);
        return new ResponseEntity<Verification>(verification, HttpStatus.OK);
    }

    /**
     * Endpoint to get the previous verification entries from the database.
     * 
     */
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ResponseEntity<List<Verification>> getHistory() {
        return new ResponseEntity<List<Verification>>(verificationService.getHistory(), HttpStatus.OK);
    }

}
