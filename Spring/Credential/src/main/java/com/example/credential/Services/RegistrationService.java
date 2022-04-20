package com.example.credential.Services;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Boolean saveUser(RegistrationModel GetObj) throws MessagingException, UnsupportedEncodingException {
        RegistrationModel reg = registrationRepo.findByEmailId(GetObj.getEmailId());
        if(reg==null) {
            OTP = generateOTP.sendVerificationEmail(GetObj.getEmailId(), GetObj.getFirstName() +" "+GetObj.getLastName());
            System.out.println(OTP);
            RegObj = GetObj;
            return true;
        }
        return false;
    }

    public Boolean checkOTP(int otp){
        if(OTP == otp){
            RegObj.setPassword(passwordEncoder.encode(RegObj.getPassword()));
            registrationRepo.save(RegObj);
            return true;
        }
        return false;
    }

    public Boolean updateUser(int id, RegistrationModel regBodyObj){
        RegistrationModel registerObj = registrationRepo.findById(id).get();
        if(registerObj==null) return false;
        else {
            registerObj.setCityModel(regBodyObj.getCityModel());
            registerObj.setContactNumber(regBodyObj.getContactNumber());
            registerObj.setEmailId(regBodyObj.getEmailId());
            registerObj.setFirstName(regBodyObj.getFirstName());
            registerObj.setPassword(passwordEncoder.encode(RegObj.getPassword()));
            registerObj.setLastName(regBodyObj.getLastName());
            registerObj.setPincode(regBodyObj.getPincode());
            registrationRepo.save(registerObj);
            return true;
        }
    }
}
