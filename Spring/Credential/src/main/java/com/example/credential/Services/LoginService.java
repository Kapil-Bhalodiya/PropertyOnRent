package com.example.credential.Services;

import com.example.credential.Config.CustomUserdetail;
import com.example.credential.Config.JwtUtill;
import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.UserProfile;
import com.example.credential.Model.UserResponse;
import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    UserProfile userProfile;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserdetail customUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtill jwtUtill;

    public RegistrationModel checkAuth(RegistrationModel registrationModel){ return registrationRepo.findByEmailIdAndPassword(registrationModel.getEmailId(),registrationModel.getPassword()); }

    public ResponseEntity<UserProfile> getUserDetail(String emailId){
        try {
            RegistrationModel registrationModel = registrationRepo.findByEmailId(emailId);
            userProfile.setEmailId(registrationModel.getEmailId());
            userProfile.setFirstName(registrationModel.getFirstName());
            userProfile.setLastName(registrationModel.getLastName());
            userProfile.setContactNumber(registrationModel.getContactNumber());
            userProfile.setCityName(registrationModel.getCityModel().getCity_name());
            userProfile.setPincode(registrationModel.getPincode());
            userProfile.setStateName(registrationModel.getCityModel().getStateModel().getState_name());
            return ResponseEntity.status(HttpStatus.OK).body(userProfile);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<UserResponse> tokenSet(RegistrationModel reg) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reg.getEmailId(), reg.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        customUserDetailService.loadUserByUsername(reg.getEmailId());
        String token = jwtUtill.doGenerateToken(reg.getEmailId());
        return ResponseEntity.ok(new UserResponse(token, reg.getEmailId()));
    }

    public Boolean changePassword(String emailId,String Password){
        RegistrationModel registerObj = registrationRepo.findByEmailId(emailId);
        if(registerObj==null) return false;
        else {
            registerObj.setPassword(passwordEncoder.encode(Password));
            registrationRepo.save(registerObj);
            return true;
        }
    }
}
