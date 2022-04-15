package com.example.adminservices.Controller;

import com.example.adminservices.Model.AmenitiesModel;
import com.example.adminservices.Service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Amenities")
public class AmenitiesController {

    @Autowired
    AmenitiesService amenitiesservice;

    @GetMapping("/Get")
    public Iterable<AmenitiesModel> GetAllAmenities()
    {
        return amenitiesservice.FindALlAmenities();
    }

    @PostMapping("/Add")
    public AmenitiesModel SaveAmenities(@RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.SaveAmenities(amenitiesModel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateAmenities(@PathVariable int ID,@RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.UpdateAmenities(ID,amenitiesModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeleteAmenities(@PathVariable int ID)
    {
        return amenitiesservice.DeleteByIDAmenities(ID);
    }

}
