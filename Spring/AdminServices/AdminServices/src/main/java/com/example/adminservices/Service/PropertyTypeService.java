package com.example.adminservices.Service;

import com.example.adminservices.Model.PropertyTypeModel;
import com.example.adminservices.Repo.PropertyTypeCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyTypeService {

    @Autowired
     public  PropertyTypeCrud propertytypecrud;

    public Iterable<PropertyTypeModel> FindAllPropertyType() {
        return propertytypecrud.findAll();
    }

    public PropertyTypeModel SavePropertyType(PropertyTypeModel propertytypemodel)
    {
        return propertytypecrud.save(propertytypemodel);
    }

    public Boolean UpdatePropertyType(int ID,PropertyTypeModel propertyTypeModel)
    {
        if(propertytypecrud.findById(ID).isPresent())
        {
            propertyTypeModel.setPropertytype_id(ID);
            propertytypecrud.save(propertyTypeModel);
            return true;
        }
        return false;
    }

    public Boolean DeleteByIDPropertyType(int ID)
    {
        if(propertytypecrud.findById(ID).isPresent())
        {
            propertytypecrud.deleteById(ID);
            return true;
        }
        return false;
    }

}
