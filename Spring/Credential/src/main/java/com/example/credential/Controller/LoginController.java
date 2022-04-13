package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.UserProfile;
import com.example.credential.Repo.RegistrationRepo;
import com.example.credential.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String chackAuth(@RequestBody RegistrationModel registrationModel){return loginService.checkAuth(registrationModel)==null ? "Invalid" : "Valid";}

    @GetMapping("/userdetail")
    public UserProfile GetDetail(@RequestParam String emailId){return loginService.getUserDetail(emailId);}

    @PutMapping("/changepassword/{EmailId}")
    public String ChangePassword(@PathVariable String EmailId,@RequestParam String NewPassword){ return loginService.changePassword(EmailId, NewPassword) ? "Password has been Changed..." : "Password has not been Changed"; }

}
