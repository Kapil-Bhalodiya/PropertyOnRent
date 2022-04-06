package com.example.credential.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registration_detail")
public class RegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String contactNumber;
    private int pincode;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModel roleModel;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel cityModel;
}
