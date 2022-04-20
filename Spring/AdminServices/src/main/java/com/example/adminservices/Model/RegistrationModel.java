package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registrationdetail")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registration_id;
    private String firstname;
    private String lastname;
    private String emailid;
    private String password;
    private String contactnumber;

    @Column(length = 6)
    private int pincode;

    @OneToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private RoleModel roleModel;


    @OneToOne
    @JoinColumn(name = "city_id",referencedColumnName = "city_id")
    private CityModel cityModel;
}
