package com.example.adminservices.Controller;

import com.example.adminservices.Model.SubAmenitiesModel;
import com.example.adminservices.Service.SubAmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SubAmenities")
public class SubAmenitiesController {

    @Autowired
    SubAmenitiesService subAmenitiesService;

    @GetMapping("/Get")
    public Iterable<SubAmenitiesModel> GetAllSubAmenities()
    {
        return subAmenitiesService.FindAllSubAmenties();
    }

    @GetMapping("/Get/{ID}")
    public Iterable<SubAmenitiesModel> GetSubAmenitieswise(@PathVariable int ID)
    {
        return subAmenitiesService.FindSubAmenitieswise(ID);
    }

    @PostMapping("/Add")
    public SubAmenitiesModel AddSubAmenities(@RequestBody SubAmenitiesModel subAmenitiesModel)
    {
        return subAmenitiesService.SaveSubAmenities(subAmenitiesModel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateSubAmenities(@PathVariable int ID,@RequestBody SubAmenitiesModel subAmenitiesModel)
    {
        return subAmenitiesService.UpdateSubAmenities(ID,subAmenitiesModel);
    }

    @DeleteMapping("Delete/{ID}")
    public Boolean DeleteSubAmenities(@PathVariable int ID)
    {
        return subAmenitiesService.DeleteByIDSubAmenities(ID);
    }

}
