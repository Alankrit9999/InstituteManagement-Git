package com.example.InstituteManagement.controller;

import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.exception.InstituteManagementException;
import com.example.InstituteManagement.service.InstituteManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class GetINstituteDetailsController {
    @Autowired
    InstituteManagementService institutemanagementService;
    @GetMapping(value = "/getInstituteDetails/{id}")
    public ResponseEntity<InstituteManagementDTO> getInstituteDetails(@PathVariable Integer id) throws InstituteManagementException {
        InstituteManagementDTO institute = institutemanagementService.getInstituteById(id);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }
}
