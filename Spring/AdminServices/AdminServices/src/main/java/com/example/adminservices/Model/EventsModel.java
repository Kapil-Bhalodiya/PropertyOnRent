package com.example.adminservices.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Events")
public class EventsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int events_id;
    private String events_name;
}
