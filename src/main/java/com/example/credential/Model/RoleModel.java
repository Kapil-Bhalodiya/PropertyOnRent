package com.example.credential.Model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue
    private int role_id;
    private String role_name;
}
