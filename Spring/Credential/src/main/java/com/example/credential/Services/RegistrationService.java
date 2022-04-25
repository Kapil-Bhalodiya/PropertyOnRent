package com.example.credential.Services;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.ResponseData;
import com.example.credential.Repo.RegistrationRepo;
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

    int OTP;
    RegistrationModel RegObj;

    public Iterable<RegistrationModel> getAllUser(){
        return registrationRepo.findAll();
    }

    public ResponseEntity<ResponseData> saveUser(RegistrationModel GetObj) throws MessagingException, UnsupportedEncodingException {
        RegistrationModel regobj = registrationRepo.findByEmailId(GetObj.getEmailId());
        if(regobj==null) {
            OTP = generateOTP.sendVerificationEmail(GetObj.getEmailId(), GetObj.getFirstName() +" "+GetObj.getLastName());
            RegObj = GetObj;
            return ResponseEntity.ok(new ResponseData(true, "OTP sent successfully..!" ));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "User Already Exist..!" ));
    }

    public ResponseEntity<ResponseData> checkOTP(int otp){
        if(OTP == otp){
            RegObj.setPassword(passwordEncoder.encode(RegObj.getPassword()));
            registrationRepo.save(RegObj);
            return ResponseEntity.ok(new ResponseData(true, "New User Added..!" ));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "OTP is Wrong..!" ));
    }
}
