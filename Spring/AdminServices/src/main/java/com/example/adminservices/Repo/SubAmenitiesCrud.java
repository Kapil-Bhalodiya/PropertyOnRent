package com.example.adminservices.Repo;

import com.example.adminservices.Model.SubAmenitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubAmenitiesCrud extends JpaRepository<SubAmenitiesModel,Integer> {

    @Query(value = "select * from subamenities where amenities_id = ?1",nativeQuery = true)
    List<SubAmenitiesModel> FindSubAmenities_Ameneitieswise(int ID);

}
