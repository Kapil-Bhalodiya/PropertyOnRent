package com.example.credential.Services;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.Response;
import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    GenerateOTP generateOTP;

    @Autowired
    PasswordEncoder passwordEncoder;

    int OTP;
    Time Genetaredtime;
    RegistrationModel RegObj;

    public Iterable<RegistrationModel> getAllUser(){
        return registrationRepo.findAll();
    }

    public ResponseEntity<Response> saveUser(RegistrationModel GetObj) throws MessagingException, UnsupportedEncodingException {
        RegistrationModel reg = registrationRepo.findByEmailId(GetObj.getEmailId());
        if(reg==null) {
            OTP = generateOTP.sendVerificationEmail(GetObj.getEmailId(), GetObj.getFirstName() +" "+GetObj.getLastName());
//            System.out.println(LocalTime.now());
//            System.out.println(Genetaredtime);
            RegObj = GetObj;
            return ResponseEntity.ok(new Response(true, "OTP sent successfully..!" ));
        }
        return ResponseEntity.badRequest().body(new Response(false, "User Already Exist..!" ));
    }

    public ResponseEntity<Response> checkOTP(int otp){
//        int CurrentTime = Genetaredtime.compareTo(new Date(System.currentTimeMillis()));
//        System.out.println(CurrentTime);
//        if(CurrentTime < 0){
//            return ResponseEntity.badRequest().body(new Response(false, "OTP Timeout..!" ));
//        }
        if(OTP == otp){
            RegObj.setPassword(passwordEncoder.encode(RegObj.getPassword()));
            registrationRepo.save(RegObj);
            return ResponseEntity.ok(new Response(true, "New User Added..!" ));
        }
        return ResponseEntity.badRequest().body(new Response(false, "OTP is Wrong..!" ));
    }

    public ResponseEntity<Response> updateUser(int id, RegistrationModel regBodyObj){
        RegistrationModel registerObj = registrationRepo.findById(id).get();
        if(registerObj==null) return ResponseEntity.badRequest().body(new Response(false, "Not Found..!" ));
        else {
            registerObj.setCityModel(regBodyObj.getCityModel());
            registerObj.setContactNumber(regBodyObj.getContactNumber());
            registerObj.setEmailId(regBodyObj.getEmailId());
            registerObj.setFirstName(regBodyObj.getFirstName());
            registerObj.setPassword(passwordEncoder.encode(RegObj.getPassword()));
            registerObj.setLastName(regBodyObj.getLastName());
            registerObj.setPincode(regBodyObj.getPincode());
            registrationRepo.save(registerObj);
            return ResponseEntity.badRequest().body(new Response(true, "Updated..!" ));
        }
    }
}
