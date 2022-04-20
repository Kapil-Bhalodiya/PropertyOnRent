package com.example.adminservices.Service;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.SubAmenitiesModel;
import com.example.adminservices.Repo.SubAmenitiesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubAmenitiesService {

    @Autowired
    SubAmenitiesCrud subamenitiescrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<SubAmenitiesModel>> FindAllSubAmenties()
    {
        try
        {
            List<SubAmenitiesModel> model=  subamenitiescrud.findAll();
            responseResult = new ResponseResult(true,false,"All SubAmenities");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<SubAmenitiesModel>> FindSubAmenitieswise(int ID)
    {
        try
        {
            List<SubAmenitiesModel> model=  subamenitiescrud.FindSubAmenities_Ameneitieswise(ID);
            responseResult = new ResponseResult(true,false,"All SubAmenities Amenitieswise");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> SaveSubAmenities(SubAmenitiesModel subAmenitiesModel)
    {
        try
        {
            subamenitiescrud.save(subAmenitiesModel);
            responseResult = new ResponseResult(true,false,"SubAmenities Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,true,"SubAmenities Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateSubAmenities(int ID,SubAmenitiesModel subAmenitiesModel)
    {
        if(subamenitiescrud.findById(ID).isPresent())
        {
            subAmenitiesModel.setSubamenities_id(ID);
            subamenitiescrud.save(subAmenitiesModel);
            responseResult = new ResponseResult(true,false,"SubAmenities Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This SubAmenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDSubAmenities(int ID)
    {
        if(subamenitiescrud.findById(ID).isPresent())
        {
            subamenitiescrud.deleteById(ID);
            responseResult = new ResponseResult(true,false,"SubAmenities Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This SubAmenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
