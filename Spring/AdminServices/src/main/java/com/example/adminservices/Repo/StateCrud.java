package com.example.adminservices.Repo;

import com.example.adminservices.Model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateCrud extends JpaRepository<StateModel,Integer> {

}
