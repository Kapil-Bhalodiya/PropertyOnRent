package com.example.adminservices.Service;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.PropertyTypeModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Repo.PropertyTypeCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeService {

    @Autowired
    public PropertyTypeCrud propertytypecrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<PropertyTypeModel>> FindAllPropertyType() {
        try {
            List<PropertyTypeModel> model = propertytypecrud.findAll();
            responseResult = new ResponseResult(true, false, "All Property");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, true, "No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> SavePropertyType(PropertyTypeModel propertytypemodel) {
        try {
            propertytypecrud.save(propertytypemodel);
            responseResult = new ResponseResult(true, false, "Property Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, true, "Property Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdatePropertyType(int ID, PropertyTypeModel propertyTypeModel) {
        if (propertytypecrud.findById(ID).isPresent()) {
            propertyTypeModel.setPropertytype_id(ID);
            propertytypecrud.save(propertyTypeModel);
            responseResult = new ResponseResult(true, false, "PropertyType Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false, true, "This PropertyType not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDPropertyType(int ID) {
        if (propertytypecrud.findById(ID).isPresent()) {
            propertytypecrud.deleteById(ID);
            responseResult = new ResponseResult(true, false, "PropertyType Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false, true, "This PropertyType not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

}
