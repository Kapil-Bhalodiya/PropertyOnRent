package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.ResponseData;
import com.example.credential.Services.RegistrationService;
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
    public Iterable<RegistrationModel> getData(){
        return registrationService.getAllUser();
    }

    @PostMapping("/saveuser")
    public ResponseEntity<ResponseData> saveData(@RequestBody RegistrationModel RegObj) throws MessagingException, UnsupportedEncodingException {
        return registrationService.saveUser(RegObj) ;
    }

    @PostMapping("/otpcode/{otp}")   //Also use as a forgort password.
    public ResponseEntity<ResponseData> getOtp(@PathVariable int otp){ return registrationService.checkOTP(otp); }
}
