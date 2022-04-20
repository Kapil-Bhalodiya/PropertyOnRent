package com.example.adminservices.Model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@Service
@Entity
@Table(name = "Amenities")
public class AmenitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenities_id;
    private String amenities_name;
}
