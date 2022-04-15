package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "state")
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int state_id;
    private String state_name;
}
