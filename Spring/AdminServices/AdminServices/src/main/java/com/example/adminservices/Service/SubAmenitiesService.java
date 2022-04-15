package com.example.adminservices.Service;

import com.example.adminservices.Model.SubAmenitiesModel;
import com.example.adminservices.Repo.SubAmenitiesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubAmenitiesService {

    @Autowired
    SubAmenitiesCrud subamenitiescrud;

    public Iterable<SubAmenitiesModel> FindAllSubAmenties()
    {
        return subamenitiescrud.findAll();
    }

    public Iterable<SubAmenitiesModel> FindSubAmenitieswise(int ID)
    {
        return subamenitiescrud.FindSubAmenities_Ameneitieswise(ID);
    }

    public SubAmenitiesModel SaveSubAmenities(SubAmenitiesModel subAmenitiesModel)
    {
        return subamenitiescrud.save(subAmenitiesModel);
    }

    public Boolean UpdateSubAmenities(int ID,SubAmenitiesModel subAmenitiesModel)
    {
        if(subamenitiescrud.findById(ID).isPresent())
        {
            subAmenitiesModel.setSubamenities_id(ID);
            subamenitiescrud.save(subAmenitiesModel);
            return true;
        }
        return false;
    }

    public Boolean DeleteByIDSubAmenities(int ID)
    {
        if(subamenitiescrud.findById(ID).isPresent())
        {
            subamenitiescrud.deleteById(ID);
            return true;
        }
        return false;
    }
}
