package com.example.adminservices.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;

    @ManyToOne
    @JoinColumn(name = "state_id",referencedColumnName = "state_id")
    private StateModel stateModel;
}
