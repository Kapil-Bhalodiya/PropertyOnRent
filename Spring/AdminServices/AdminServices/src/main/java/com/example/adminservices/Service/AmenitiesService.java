package com.example.adminservices.Service;

import com.example.adminservices.Model.AmenitiesModel;
import com.example.adminservices.Repo.AmenitiesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmenitiesService {

    @Autowired
    AmenitiesCrud amenitiescrud;

    public Iterable<AmenitiesModel> FindALlAmenities()
    {
        return amenitiescrud.findAll();
    }

    public AmenitiesModel SaveAmenities(AmenitiesModel amenitiesModel)
    {
        return amenitiescrud.save(amenitiesModel);
    }

    public Boolean UpdateAmenities(int ID,AmenitiesModel amenitiesModel)
    {
        if(amenitiescrud.findById(ID).isPresent())
        {
            amenitiesModel.setAmenities_id(ID);
            amenitiescrud.save(amenitiesModel);
            return true;
        }
        return false;
    }

    public Boolean DeleteByIDAmenities(int ID)
    {
        if(amenitiescrud.findById(ID).isPresent())
        {
            amenitiescrud.deleteById(ID);
            return true;
        }
        return false;
    }
}
