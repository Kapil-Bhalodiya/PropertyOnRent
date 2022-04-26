package com.example.adminservices.Repo;

import com.example.adminservices.Model.AmenitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesCrud extends JpaRepository<AmenitiesModel, Integer> {

}
