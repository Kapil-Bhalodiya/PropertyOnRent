package com.example.credential.Services;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.UserProfile;
import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    UserProfile userProfile;

    public RegistrationModel checkAuth(RegistrationModel registrationModel){ return registrationRepo.findByEmailIdAndPassword(registrationModel.getEmailId(),registrationModel.getPassword()); }

    public UserProfile getUserDetail(String emailId){
        RegistrationModel registrationModel = registrationRepo.findByEmailId(emailId);
        userProfile.setEmailId(registrationModel.getEmailId());
        userProfile.setFirstName(registrationModel.getFirstName());
        userProfile.setLastName(registrationModel.getLastName());
        userProfile.setContactNumber(registrationModel.getContactNumber());
        userProfile.setCityName(registrationModel.getCityModel().getCity_name());
        userProfile.setPincode(registrationModel.getPincode());
        userProfile.setStateName(registrationModel.getCityModel().getStateModel().getState_name());
        return userProfile;
    }

    public Boolean changePassword(String emailId,String Password){
        RegistrationModel registerObj = registrationRepo.findByEmailId(emailId);
        if(registerObj==null) return false;
        else {
            registerObj.setPassword(Password);
            registrationRepo.save(registerObj);
            return true;
        }
    }
}
