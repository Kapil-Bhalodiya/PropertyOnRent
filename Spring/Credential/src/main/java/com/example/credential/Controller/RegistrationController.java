package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.Response;
import com.example.credential.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
    public ResponseEntity<Response> saveData(@RequestBody RegistrationModel RegObj) throws MessagingException, UnsupportedEncodingException {
        return registrationService.saveUser(RegObj) ;
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable int id, @RequestBody RegistrationModel regBodyObj) {return registrationService.updateUser(id,regBodyObj);}

    @PostMapping("/otpcode/{otp}")   //Also use as a forgort password.
    public ResponseEntity<Response> getOtp(@PathVariable int otp){ return registrationService.checkOTP(otp); }
}
