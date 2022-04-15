package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Amenities")
public class AmenitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenities_id;
    private String amenities_name;

}
