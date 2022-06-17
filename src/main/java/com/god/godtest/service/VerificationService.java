package com.god.godtest.service;

import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.god.godtest.model.CustomArrayList;
import com.god.godtest.model.Repair;
import com.god.godtest.model.Replacement;
import com.god.godtest.model.Verification;
import com.god.godtest.model.WorkOrder;
import com.god.godtest.repository.VerificationRepository;

@Service
public class VerificationService {

    @Autowired
    VerificationRepository verificationRepository;

    public Verification createVerification(Verification verification) {
        try {
            return verificationRepository.save(verification);
        } catch (Exception e) {
            return null;
        }

    }

    public List<Verification> getHistory() {
        try {
            return verificationRepository.findAll();
        } catch (Exception e) {
            return null;
        }

    }

    public List<String> verifyRequest(WorkOrder order) {
        List<String> errors = new CustomArrayList();
        errors.add(verifyDepartment(order.getDepartment()));
        errors.add(verifyDates(order.getStartDate(), order.getEndDate()));
        errors.add(verifyCurrency(order.getCurrency()));
        errors.add(verifyPrice(order.getCost()));
        return errors;
    }

    public List<String> verifyReplacement(Replacement order) {
        List<String> errors = new CustomArrayList();
        errors.add(order.getFactoryName() == null ? "Factory name is null" : null);
        errors.add(verifyFactoryOrderNumber(order.getFactoryOrderNumber()));
        errors.add(verifyPartsInventoryNumber(order.getParts()));

        return errors;
    }

    public List<String> verifyRepair(Repair order) {
        List<String> errors = new CustomArrayList();
        errors.add(verifyAnalysisDate(order.getAnalysisDate(), order.getStartDate(), order.getEndDate()));
        errors.add(verifyTestDate(order.getTestDate(), order.getStartDate(), order.getEndDate()));
        errors.add(order.getResponsiblePerson() == null ? "Responsible person is null" : null);
        errors.add(verifyPartsCount(order.getParts()));
        return errors;
    }

    private String verifyFactoryOrderNumber(String factoryOrderNumber) {
        if (factoryOrderNumber.length() != 10)
            return "Factory Order number length should be 10";
        if (!factoryOrderNumber.substring(0, 2).matches("[a-zA-Z]+"))
            return "Factory Order number should start with 2 alphabets";
        if (factoryOrderNumber.substring(2).matches(".*[a-zA-Z]+.*"))
            return "Factory Order number should contains only number after 2nd alphabet";
        return null;
    }

    private String verifyPartsInventoryNumber(List<com.god.godtest.model.Part> parts) {
        for (com.god.godtest.model.Part part : parts) {
            if (part.getInventoryNumber() == null)
                return "Parts inventory number is null";
        }
        return null;
    }

    private String verifyPartsCount(List<com.god.godtest.model.Part> parts) {
        int total = 0;
        for (com.god.godtest.model.Part part : parts) {
            total += part.getCount();
        }
        if (total == 0)
            return "Total parts is 0";
        return null;
    }

    private String verifyTestDate(Date testDate, Date startDate, Date endDate) {

        if (testDate == null)
            return "Test date is null";

        if (testDate.after(endDate))
            return "Test date is after end date";

        if (testDate.before(startDate))
            return "Test date is before start date";

        return null;
    }

    private String verifyAnalysisDate(Date analysisDate, Date startDate, Date endDate) {
        if (analysisDate.after(endDate))
            return "Analysis date is after end date";

        if (analysisDate.before(startDate))
            return "Analysis date is before start date";

        return null;
    }

    private String verifyDepartment(String department) {
        List<String> validDepartmentList = Arrays.asList("GOoD analysis department", "GOoD repair department",
                "GOoD replacement department");

        if (department == null)
            return "Department is empty";

        if (!validDepartmentList.contains(department))
            return "Not valid department";

        return null;
    }

    private String verifyDates(Date startDate, Date endDate) {
        if (startDate == null)
            return "Start date is empty";

        if (startDate.after(new Date()))
            return "Start date is after current date";

        if (endDate == null)
            return "end date is empty";

        if (endDate.before(startDate))
            return "End date is before start date";

        return null;
    }

    private String verifyCurrency(String currency) {
        if (currency != null) {
            try {
                Currency.getInstance(currency);
            } catch (IllegalArgumentException e) {
                return "Currency is not valid ISO code";
            }
        }
        return null;
    }

    private String verifyPrice(double cost) {
        if (cost <= 0) {
            return "cost should be greater than 0";
        }
        return null;
    }

}