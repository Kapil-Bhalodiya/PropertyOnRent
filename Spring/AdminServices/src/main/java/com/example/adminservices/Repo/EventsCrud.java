package com.example.adminservices.Repo;

import com.example.adminservices.Model.EventsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsCrud extends JpaRepository<EventsModel,Integer> {

}
