package com.example.adminservices.Repo;

import com.example.adminservices.Model.PropertyTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeCrud extends JpaRepository<PropertyTypeModel,Integer> {

}
