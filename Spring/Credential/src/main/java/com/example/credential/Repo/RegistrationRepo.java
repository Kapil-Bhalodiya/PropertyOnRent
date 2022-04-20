package com.example.credential.Repo;

import com.example.credential.Model.RegistrationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<RegistrationModel,Integer> {

     @Query(value = "select * from registration_detail where email_id = ?1 and password = ?2",nativeQuery = true)
     RegistrationModel findByEmailIdAndPassword(String EmailId,String Password);

    @Query(value = "select * from registration_detail where email_id = ?1",nativeQuery = true)
    RegistrationModel findByEmailId(String EmailId);
}
