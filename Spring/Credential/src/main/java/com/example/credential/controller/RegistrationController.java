package com.example.credential.controller;

import com.example.credential.model.RegistrationModel;
import com.example.credential.model.ResponseData;
import com.example.credential.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/getalluser")
    public Iterable<RegistrationModel> getData() {
        return registrationService.getAllUser();
    }

    @PostMapping("/saveuser")
    public ResponseEntity<ResponseData> saveNewUser(@RequestBody RegistrationModel registrationModel) throws MessagingException, UnsupportedEncodingException {
        return registrationService.saveUser(registrationModel);
    }

    @PostMapping("/otpcode/{otp}")   //Also use as a forgort password.
    public ResponseEntity<ResponseData> checkOTP(@PathVariable int otp) {
        return registrationService.checkOTP(otp);
    }
}
