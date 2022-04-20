package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
    public String saveData(@RequestBody RegistrationModel RegObj) throws MessagingException, UnsupportedEncodingException {
        return registrationService.saveUser(RegObj) ? "OTP sent..!" : "User Already Exist";
    }

    @PutMapping("/updateUser/{id}")
    public Boolean updateUser(@PathVariable int id,@RequestBody RegistrationModel regBodyObj) {return registrationService.updateUser(id,regBodyObj) ? true : false;}

    @PostMapping("/otpcode/{otp}")   //Also use as a forgort password.
    public Boolean getOtp(@PathVariable int otp){
        System.out.println("Inside conroller : "+otp);
        return registrationService.checkOTP(otp);}

    @GetMapping("/Demo")
    public String check(){return "Checked....!";}
}
