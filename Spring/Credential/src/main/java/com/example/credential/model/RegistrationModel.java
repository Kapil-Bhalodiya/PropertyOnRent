package com.example.credential.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registrationdetail")
public class RegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int registrationId;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contactNumber;

    private int pincode;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel roleModel;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "cityId", nullable = false)
    private CityModel cityModel;
}
