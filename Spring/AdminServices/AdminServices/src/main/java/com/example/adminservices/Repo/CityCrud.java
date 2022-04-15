package com.example.adminservices.Repo;

import com.example.adminservices.Model.CityModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CityCrud extends CrudRepository<CityModel,Integer> {

    @Query(value = "select * from city where state_id = ?",nativeQuery = true)
    Iterable<CityModel> FindCityStatewise(int ID);
}
