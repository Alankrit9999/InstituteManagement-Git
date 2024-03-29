package com.example.InstituteManagement.entity;

import jakarta.persistence.*;
import lombok.*;




@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class InstituteManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable=false)
    String instituteName;
    @Column(nullable=false)
    long instituteContact;
    @Column(nullable=false)
    String instituteLocation;

    public void setId(int id) {
        this.id = id;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public void setInstituteContact(long instituteContact) {
        this.instituteContact = instituteContact;
    }

    public void setInstituteLocation(String instituteLocation) {
        this.instituteLocation = instituteLocation;
    }
    @Override
    public String toString() {
        return "InstituteManagement [id=" + id + ", instituteName=" + instituteName + ", instituteContact="
                + instituteContact + ", instituteLocation=" + instituteLocation + "]";
    }
}
