package com.example.credential.Repo;

import com.example.credential.Model.RegistrationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<RegistrationModel,Integer> {

    RegistrationModel findByEmailIdAndPassword(String EmailId,String Password);

    RegistrationModel findByEmailId(String EmailId);
}
