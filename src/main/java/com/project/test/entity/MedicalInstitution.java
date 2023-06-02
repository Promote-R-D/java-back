package com.project.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ddo")
    private String ddo;

    @Column(name="si")
    private String si;

    @Column(name="gu")
    private String gu;
    @Column(name="dong")
    private String dong;

    @Column(name="road")
    private String road;

    @Column(name="medical_institution")
    private String medicalInstitution;

    @Column(name="hospital_name")
    private String hospitalName;

    @Column(name="medical_department")
    private String medicalDepartment;

    @Column(name="number_of_beds")
    private String numberOfBeds;

    @Column(name="address")
    private String address;
    @Column(name="lat")
    private double lat;

    @Column(name="lng")
    private double lng;

    @Column(name="phone_number")
    private String phoneNumber;
    @Transient
    private String distance;
    public void setDistance(String distance) {
        this.distance = distance;
    }
}
