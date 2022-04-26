package com.example.adminservices.Repo;

import com.example.adminservices.Model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityCrud extends JpaRepository<CityModel, Integer> {

    @Query(value = "select * from city where state_id = ?", nativeQuery = true)
    List<CityModel> FindCityStatewise(int ID);
}
