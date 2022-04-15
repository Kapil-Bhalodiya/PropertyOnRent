package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Propertytype")
public class PropertyTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertytype_id;
    private String propertytype_name;
}
