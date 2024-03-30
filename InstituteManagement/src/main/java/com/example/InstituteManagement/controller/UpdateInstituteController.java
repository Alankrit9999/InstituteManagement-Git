package com.example.InstituteManagement.controller;

import com.example.InstituteManagement.exception.InstituteManagementException;
import com.example.InstituteManagement.service.InstituteManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.InstituteManagement.dto.InstituteManagementDTO;
public class UpdateInstituteController {
    @Autowired
    InstituteManagementService institutemanagementService;
    @CrossOrigin
    @PutMapping(value = "/updateInstitute/{id}")
    public ResponseEntity<String> updateInstitute(@Validated @PathVariable Integer id, String instituteName, Long instituteContact, String instituteLocation, @RequestBody InstituteManagementDTO institute)
            throws InstituteManagementException {
        institutemanagementService.updateInstitute(id, institute.getInstituteLocation(),institute.getInstituteContact(),institute.getInstituteLocation());
        String successMessage = "INSTITUTE GOT UPDATED SUCCESSFULLY WITH ID:- "+id;
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}
