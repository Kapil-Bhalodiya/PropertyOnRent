package com.example.adminservices.Controller;

import com.example.adminservices.Model.AmenitiesModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Amenities")
public class AmenitiesController {

    @Autowired
    AmenitiesService amenitiesservice;

    @GetMapping("/Get")
    public ResponseEntity<List<AmenitiesModel>> GetAllAmenities()
    {
        return amenitiesservice.FindALlAmenities();
    }

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> SaveAmenities(@RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.SaveAmenities(amenitiesModel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateAmenities(@PathVariable int ID, @RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.UpdateAmenities(ID,amenitiesModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteAmenities(@PathVariable int ID)
    {
        return amenitiesservice.DeleteByIDAmenities(ID);
    }

}
