package com.example.credential.services;

import com.example.credential.model.RegistrationModel;
import com.example.credential.model.ResponseData;
import com.example.credential.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    GenerateOTP generateOTP;

    @Autowired
    PasswordEncoder passwordEncoder;

    int setOTP;
    RegistrationModel setRegistrationModel;

    public Iterable<RegistrationModel> getAllUser(){
        return registrationRepo.findAll();
    }

    public ResponseEntity<ResponseData> saveUser(RegistrationModel registrationModel) throws MessagingException, UnsupportedEncodingException {
        RegistrationModel registrationModelObject = registrationRepo.findByEmailId(registrationModel.getEmailId());
        if(registrationModelObject==null) {
            setOTP = generateOTP.sendVerificationEmail(registrationModel.getEmailId(), registrationModel.getFirstName() +" "+registrationModel.getLastName());
            setRegistrationModel = registrationModel;
            return ResponseEntity.ok(new ResponseData(true, "OTP sent successfully..!" ));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "User Already Exist..!" ));
    }

    public ResponseEntity<ResponseData> checkOTP(int getOTP){
        if(setOTP == getOTP){
            setRegistrationModel.setPassword(passwordEncoder.encode(setRegistrationModel.getPassword()));
            registrationRepo.save(setRegistrationModel);
            return ResponseEntity.ok(new ResponseData(true, "New User Added..!" ));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "OTP is Wrong..!" ));
    }
}
