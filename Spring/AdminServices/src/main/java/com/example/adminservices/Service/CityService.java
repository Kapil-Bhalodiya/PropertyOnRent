package com.example.adminservices.Service;

import com.example.adminservices.Model.AmenitiesModel;
import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Repo.CityCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityCrud citycrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<ResponseResult> SaveCity(CityModel citymodel) {
        try {
            citycrud.save(citymodel);
            responseResult = new ResponseResult(true, false, "City Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, true, "City Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateCity(int ID, CityModel cityModel) {
        if (citycrud.findById(ID).isPresent()) {
            cityModel.setCity_id(ID);
            citycrud.save(cityModel);
            responseResult = new ResponseResult(true, false, "City Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false, true, "This city not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<List<CityModel>> FindAllCity() {
        try {
            List<CityModel> model = citycrud.findAll();
            responseResult = new ResponseResult(true, false, "All City");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, true, "No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> DeleteByIDCity(int ID) {
        if (citycrud.findById(ID).isPresent()) {
            citycrud.deleteById(ID);
            responseResult = new ResponseResult(true, false, "City Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false, true, "This city not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<List<CityModel>> FindCityStatewise(int ID) {
        try {
            List<CityModel> model = citycrud.FindCityStatewise(ID);
            responseResult = new ResponseResult(true, false, "Statewise city");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, true, "No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }
}
