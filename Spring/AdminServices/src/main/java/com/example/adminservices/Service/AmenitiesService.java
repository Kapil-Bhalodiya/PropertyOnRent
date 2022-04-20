package com.example.adminservices.Service;

import com.example.adminservices.Model.AmenitiesModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Repo.AmenitiesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmenitiesService {

    @Autowired
    AmenitiesCrud amenitiescrud;

    @Autowired
    ResponseResult responseResult;

    @Autowired
    AmenitiesModel amenitiesModel;

    public ResponseEntity<List<AmenitiesModel>> FindALlAmenities()
    {
        try
        {
            List<AmenitiesModel> model= amenitiescrud.findAll();
            responseResult = new ResponseResult(true,false,"All Amenities");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> SaveAmenities(AmenitiesModel amenitiesModel)
    {
        try{
            amenitiescrud.save(amenitiesModel);
            responseResult = new ResponseResult(true,false,"Amenities Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,true,"Amenities Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateAmenities(int ID,AmenitiesModel amenitiesModel)
    {
        if(amenitiescrud.findById(ID).isPresent())
        {
            amenitiesModel.setAmenities_id(ID);
            amenitiescrud.save(amenitiesModel);

            responseResult = new ResponseResult(true,false,"Amenities Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This amenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDAmenities(int ID)
    {
        if(amenitiescrud.findById(ID).isPresent())
        {
            amenitiescrud.deleteById(ID);
            responseResult = new ResponseResult(true,false,"Amenities Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This amenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
