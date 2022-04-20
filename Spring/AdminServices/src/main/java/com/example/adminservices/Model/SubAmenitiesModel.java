package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Subamenities")
public class SubAmenitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subamenities_id;
    private String subamenities_name;

    @ManyToOne
    @JoinColumn(name = "amenities_id",referencedColumnName = "amenities_id")
    private AmenitiesModel amenitiesModel;
}
