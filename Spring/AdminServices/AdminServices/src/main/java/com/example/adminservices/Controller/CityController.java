package com.example.adminservices.Controller;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/City")
public class CityController {

    @Autowired
    CityService cityservice;

    @PostMapping("/Add")
    public CityModel AddCity(@RequestBody CityModel citymodel)
    {
        return cityservice.SaveCity(citymodel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateCity(@PathVariable int ID,@RequestBody CityModel citymodel)
    {
        return cityservice.UpdateCity(ID,citymodel);
    }

    @GetMapping("/Get")
    public Iterable<CityModel> GetAllCity()
    {
        return cityservice.FindAllCity();
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeleteCity(@PathVariable int ID)
    {
        return cityservice.DeleteByIDCity(ID);
    }

    @GetMapping("/GetCityStatewise/{ID}")
    public Iterable<CityModel> GetCityStatewise(@PathVariable int ID)
    {
        return cityservice.FindCityStatewise(ID);
    }

}

