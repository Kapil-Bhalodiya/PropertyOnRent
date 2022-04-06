package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/GetUser")
    public Iterable<RegistrationModel> getData(){
        return registrationService.getAllUser();
    }

    @PostMapping("/SaveUser")
    public RegistrationModel saveData(@RequestBody RegistrationModel RegObj) { return registrationService.saveUser(RegObj); }

    @GetMapping("/Demo")
    public String check(){
        return "Checked....!";
    }
}
