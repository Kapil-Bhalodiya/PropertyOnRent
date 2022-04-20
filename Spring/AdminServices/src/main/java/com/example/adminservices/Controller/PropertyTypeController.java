package com.example.adminservices.Controller;

import com.example.adminservices.Model.PropertyTypeModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PropertyType")
public class PropertyTypeController {

    @Autowired
    public PropertyTypeService propertytypeservice;

    @GetMapping("/Get")
    public ResponseEntity<List<PropertyTypeModel>> GetAllPropertyType()
    {
        return propertytypeservice.FindAllPropertyType();
    }

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddPropertyType(@RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.SavePropertyType(propertyTypeModel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdatePropertyType(@PathVariable int ID, @RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.UpdatePropertyType(ID,propertyTypeModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeletePropertyType(@PathVariable int ID)
    {
        return propertytypeservice.DeleteByIDPropertyType(ID);
    }
}
