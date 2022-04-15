package com.example.adminservices.Service;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Repo.CityCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityCrud citycrud;

    public CityModel SaveCity(CityModel citymodel)
    {
        return citycrud.save(citymodel);
    }

    public Boolean UpdateCity(int ID,CityModel cityModel)
    {
        if(citycrud.findById(ID).isPresent())
        {
            cityModel.setCity_id(ID);
            citycrud.save(cityModel);
            return true;
        }
        return false;
    }

    public Iterable<CityModel> FindAllCity()
    {
        return citycrud.findAll();
    }

    public Boolean DeleteByIDCity(int ID)
    {
        if(citycrud.findById(ID).isPresent())
        {
            citycrud.deleteById(ID);
            return true;
        }
        return false;
    }

    public Iterable<CityModel> FindCityStatewise(int ID)
    {
        return citycrud.FindCityStatewise(ID);
    }
}
