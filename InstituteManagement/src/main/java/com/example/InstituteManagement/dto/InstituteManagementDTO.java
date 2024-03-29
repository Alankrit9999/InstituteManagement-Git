package com.example.InstituteManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstituteManagementDTO {
    int id;
    @NotEmpty
    String instituteName;
    @NotNull
    long instituteContact;
    @NotEmpty
    String instituteLocation;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getInstituteName() {
        return instituteName;
    }
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
    public long getInstituteContact() {
        return instituteContact;
    }
    public void setInstituteContact(long instituteContact) {
        this.instituteContact = instituteContact;
    }
    public String getInstituteLocation() {
        return instituteLocation;
    }
    public void setInstituteLocation(String instituteLocation) {
        this.instituteLocation = instituteLocation;
    }
    @Override
    public String toString() {
        return "InstituteManagementDTO [id=" + id + ", instituteName=" + instituteName + ", instituteContact="
                + instituteContact + ", instituteLocation=" + instituteLocation + "]";
    }
}
