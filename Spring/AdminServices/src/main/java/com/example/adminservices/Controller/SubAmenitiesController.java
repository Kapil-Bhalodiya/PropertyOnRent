package com.example.adminservices.Controller;

import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.SubAmenitiesModel;
import com.example.adminservices.Service.SubAmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SubAmenities")
public class SubAmenitiesController {

    @Autowired
    SubAmenitiesService subAmenitiesService;

    @GetMapping("/Get")
    public ResponseEntity<List<SubAmenitiesModel>> GetAllSubAmenities() {
        return subAmenitiesService.FindAllSubAmenties();
    }

    @GetMapping("/Get/{ID}")
    public ResponseEntity<List<SubAmenitiesModel>> GetSubAmenitieswise(@PathVariable int ID) {
        return subAmenitiesService.FindSubAmenitieswise(ID);
    }

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddSubAmenities(@RequestBody SubAmenitiesModel subAmenitiesModel) {
        return subAmenitiesService.SaveSubAmenities(subAmenitiesModel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateSubAmenities(@PathVariable int ID, @RequestBody SubAmenitiesModel subAmenitiesModel) {
        return subAmenitiesService.UpdateSubAmenities(ID, subAmenitiesModel);
    }

    @DeleteMapping("Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteSubAmenities(@PathVariable int ID) {
        return subAmenitiesService.DeleteByIDSubAmenities(ID);
    }

}
