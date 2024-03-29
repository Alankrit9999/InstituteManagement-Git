package com.example.InstituteManagement.service;
import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.exception.InstituteManagementException;
public interface InstituteManagementService {

    public Integer registerInstitute(InstituteManagementDTO institute) throws InstituteManagementException;
    public String updateInstitute(Integer id, String instituteName, Long instituteContact,String instituteLocation) throws  InstituteManagementException;
    public InstituteManagementDTO getInstituteById(Integer id) throws InstituteManagementException;
}
