package com.example.credential.Repo;

import com.example.credential.Model.RegistrationModel;
import com.example.credential.Model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<RegistrationModel,Integer> {

     @Query(value = "select * from registration_detail where email_id = ?1 and password = ?2",nativeQuery = true)
     RegistrationModel findByEmailIdAndPassword(String EmailId,String Password);

    @Query(value = "select * from registration_detail where email_id = ?",nativeQuery = true)
    RegistrationModel findByEmailId(String EmailId);

//    UserProfile findUserDetail(String emailId);
//    @Query(value = "select " +
//            "r.first_name,r.last_name,r.email_id,r.contact_number,r.pincode,c.city_name,s.state_name  "+
//            " from registration_detail r,city c,state s where c.city_id=r.city_id and s.state_id=c.state_id and r.email_id = ?",nativeQuery = true)
//    RegistrationModel findByUSerDetail(String EmailId);
}
