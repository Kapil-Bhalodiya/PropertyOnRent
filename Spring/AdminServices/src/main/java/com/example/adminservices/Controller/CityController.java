package com.example.adminservices.Controller;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/City")
public class CityController {

    @Autowired
    CityService cityservice;

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddCity(@RequestBody CityModel citymodel) {
        return cityservice.SaveCity(citymodel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateCity(@PathVariable int ID, @RequestBody CityModel citymodel) {
        return cityservice.UpdateCity(ID, citymodel);
    }

    @GetMapping("/Get")
    public ResponseEntity<List<CityModel>> GetAllCity() {
        return cityservice.FindAllCity();
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteCity(@PathVariable int ID) {
        return cityservice.DeleteByIDCity(ID);
    }

    @GetMapping("/GetCityStatewise/{ID}")
    public ResponseEntity<List<CityModel>> GetCityStatewise(@PathVariable int ID) {
        return cityservice.FindCityStatewise(ID);
    }

}

