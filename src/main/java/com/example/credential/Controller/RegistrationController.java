package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/GetAllUser")
    public Iterable<RegistrationModel> getData(){
        return registrationService.getAllUser();
    }

    @PostMapping("/SaveUser")
    public String saveData(@RequestBody RegistrationModel RegObj) throws MessagingException, UnsupportedEncodingException {
        System.out.println(RegObj);
        return registrationService.saveUser(RegObj) ? "Inserted..!" : "User Already Exist";
    }

    @PutMapping("/UpdateUser/{id}")
    public Boolean updateUser(@PathVariable int id,@RequestBody RegistrationModel regBodyObj) {return registrationService.updateUser(id,regBodyObj) ? true : false;}

    @PostMapping("/OTPCode")
    public Boolean getOtp(@RequestParam int otp){return registrationService.checkOTP(otp);}

    @GetMapping("/Demo")
    public String check(){return "Checked....!";}
}
