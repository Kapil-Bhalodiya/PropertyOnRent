package com.example.adminservices.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String role_name;
}
