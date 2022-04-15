package com.example.adminservices.Repo;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.SubAmenitiesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SubAmenitiesCrud extends CrudRepository<SubAmenitiesModel,Integer> {

    @Query(value = "select * from subamenities where amenities_id = ?",nativeQuery = true)
    Iterable<SubAmenitiesModel> FindSubAmenities_Ameneitieswise(int ID);

}
