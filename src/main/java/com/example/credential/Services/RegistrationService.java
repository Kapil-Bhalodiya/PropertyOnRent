package com.example.credential.Services;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    public Iterable<RegistrationModel> getAllUser(){
        return registrationRepo.findAll();
    }

    public RegistrationModel saveUser(RegistrationModel RegObj) {return registrationRepo.save(RegObj); }
}
