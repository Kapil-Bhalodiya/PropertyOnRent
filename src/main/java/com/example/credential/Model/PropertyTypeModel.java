package com.example.credential.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PropertyTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PropertyTypeId;
    private String PropertyTypeName;
}
