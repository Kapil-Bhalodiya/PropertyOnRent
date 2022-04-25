package com.example.credential.Controller;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.ResponseData;
import com.example.credential.Model.UserProfile;
import com.example.credential.Model.UserResponse;
import com.example.credential.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/userprofile/{emailId}")
    public ResponseEntity<UserProfile> GetDetail(@PathVariable String emailId){
        System.out.println(LocalTime.now());
        return loginService.getUserDetail(emailId);
    }

    @PostMapping("/check")
    public String chackAuth(@RequestBody RegistrationModel registrationModel){return loginService.checkAuth(registrationModel)==null ? "Invalid" : "Valid";}

    @PostMapping("/authentication")
    public ResponseEntity<UserResponse> generateToken(@RequestBody RegistrationModel reg) throws Exception {
       return loginService.tokenSet(reg); }

    @PutMapping("/changepassword/{EmailId}")
    public ResponseEntity<ResponseData> ChangePassword(@PathVariable String EmailId, @RequestParam String NewPassword){ return loginService.changePassword(EmailId, NewPassword); }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ResponseData> updateUser(@PathVariable int id, @RequestBody RegistrationModel regBodyObj) {return loginService.updateUser(id,regBodyObj);}

    @GetMapping("/userRole")
    public String GetDetails(){return "user";}

    @GetMapping("/vendorRole")
    public String GetDetailsd(){return "Vendor";}

    @GetMapping("/adminRole")
    public String GetDetailss(){return "admin";}
}
