package com.example.InstituteManagement.controller;

import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.exception.InstituteManagementException;
import com.example.InstituteManagement.service.InstituteManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class InstituteRegistrationController {
    @Autowired
    InstituteManagementService institutemanagementService;
    @Autowired
    Environment environment;
    @PostMapping(value = "/registerInstitute")
    public ResponseEntity<String> registerInstitute(@Validated @RequestBody InstituteManagementDTO institute) throws InstituteManagementException {
        // handle request
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Content-Type", "application/json");
        Integer instituteId = institutemanagementService.registerInstitute(institute);
        String successMessage = "Institute registration Successfull with id:- "+ instituteId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
