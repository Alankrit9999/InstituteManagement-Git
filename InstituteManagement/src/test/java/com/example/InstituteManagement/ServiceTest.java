package com.example.InstituteManagement;

import com.example.InstituteManagement.dto.InstituteManagementDTO;
import com.example.InstituteManagement.entity.InstituteManagement;
import com.example.InstituteManagement.exception.InstituteManagementException;
import com.example.InstituteManagement.repository.InstituteManagementRepo;
import com.example.InstituteManagement.service.InstituteManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private InstituteManagementRepo instituteManagementRepo;

    @InjectMocks
    private InstituteManagementServiceImpl instituteService;

    @Test
    public void testRegisterInstitute_success() throws InstituteManagementException {
        // Prepare test data
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        instituteDTO.setInstituteName("abc Institute");
        instituteDTO.setInstituteContact(1234567890);
        instituteDTO.setInstituteLocation("noida");

        when(instituteManagementRepo.findByInstituteName("abc Institute")).thenReturn(null);
        when(instituteManagementRepo.save(any())).thenReturn(new InstituteManagement());

        Integer id = instituteService.registerInstitute(instituteDTO);

        assertNotNull(id);
        verify(instituteManagementRepo, times(1)).save(any()); // Use captured argument
    }
    @Test
    public void testRegisterInstitute_ExistingInstitute_ExceptionThrown() {
        InstituteManagementDTO instituteDTO = new InstituteManagementDTO();
        instituteDTO.setInstituteName("Existing Institute");
        instituteDTO.setInstituteContact(1234567890);
        instituteDTO.setInstituteLocation("Location");

        when(instituteManagementRepo.findByInstituteName("Existing Institute")).thenReturn(new InstituteManagement());

        assertThrows(InstituteManagementException.class, () -> {
            instituteService.registerInstitute(instituteDTO);
        });

        verify
                (instituteManagementRepo, never()).save(any());
    }
}
