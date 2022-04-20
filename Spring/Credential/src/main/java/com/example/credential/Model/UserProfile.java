package com.example.credential.Model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserProfile {
    private String FirstName;
    private String LastName;
    private String EmailId;
    private String ContactNumber;
    private int Pincode;
    private String CityName;
    private String StateName;
}
