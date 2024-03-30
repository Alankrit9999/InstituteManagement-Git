package com.example.InstituteManagement;

import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.service.InstituteManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetInstituteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstituteManagementService instituteManagementService;
    @Test
    public void testGetInstituteDetails_Success() throws Exception {
        Integer instituteId = 1;
        InstituteManagementDTO expectedInstitute = new InstituteManagementDTO(); // Set expected details

        when(instituteManagementService.getInstituteById(instituteId)).thenReturn(expectedInstitute);

        MvcResult result = mockMvc.perform(get("/getInstituteDetails/{id}", instituteId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        // Assert response content if needed
    }
}
