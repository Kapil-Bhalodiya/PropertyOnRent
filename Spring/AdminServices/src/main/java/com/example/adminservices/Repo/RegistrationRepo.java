package com.example.adminservices.Repo;

import com.example.adminservices.Model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrationRepo extends JpaRepository<RegistrationModel,Integer> {

    @Query(value = "select * from registrationdetail where registration_id = ?1",nativeQuery = true)
    RegistrationModel getRegistration(int id);
}
