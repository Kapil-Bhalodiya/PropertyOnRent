package com.example.adminservices.Controller;

import com.example.adminservices.Model.RoleModel;
import com.example.adminservices.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    RoleService roleservice;

    @GetMapping("/Get")
    public Iterable<RoleModel> GetAllRole()
    {
        return roleservice.FindAllRole();
    }

    @PostMapping("/Add")
    public RoleModel AddRole(@RequestBody RoleModel rolemodel)
    {
        return roleservice.AddRole(rolemodel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateRole(@PathVariable int ID,@RequestBody RoleModel rolemodel)
    {
        return roleservice.UpdateRole(ID,rolemodel);
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeleteRole(@PathVariable int ID)
    {
        return roleservice.DeleteByIDRole(ID);
    }
}
