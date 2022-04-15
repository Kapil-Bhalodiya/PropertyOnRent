package com.example.adminservices.Repo;

import com.example.adminservices.Model.EventsModel;
import org.springframework.data.repository.CrudRepository;

public interface EventsCrud extends CrudRepository<EventsModel,Integer> {

}
