package com.example.adminservices.Controller;

import com.example.adminservices.Model.PropertyTypeModel;
import com.example.adminservices.Service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/PropertyType")
public class PropertyTypeController {

    @Autowired
    public PropertyTypeService propertytypeservice;

    @GetMapping("/Get")
    public Iterable<PropertyTypeModel> GetAllPropertyType()
    {
        return propertytypeservice.FindAllPropertyType();
    }

    @PostMapping("/Add")
    public PropertyTypeModel AddPropertyType(@RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.SavePropertyType(propertyTypeModel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdatePropertyType(@PathVariable int ID,@RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.UpdatePropertyType(ID,propertyTypeModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeletePropertyType(@PathVariable int ID)
    {
        return propertytypeservice.DeleteByIDPropertyType(ID);
    }



}
