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
public class LocationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="field")
    private String field;

    @Column(name="detail_field")
    private String detailField;

    @Column(name="system_name")
    private String systemName;

    @Column(name="related_information")
    private String relatedInformation;
    @Column(name="ddo")
    private String ddo;

    @Column(name="si")
    private String si;

    @Column(name="dong")
    private String dong;

    @Column(name="road")
    private String road;
    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="lat")
    private double lat;

    @Column(name="lng")
    private double lng;
}
