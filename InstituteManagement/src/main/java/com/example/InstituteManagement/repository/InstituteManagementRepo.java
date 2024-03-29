package com.example.InstituteManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.entity.InstituteManagement;
public interface InstituteManagementRepo extends JpaRepository<InstituteManagement,Integer> {

    InstituteManagement findByInstituteName(String instituteName);

}