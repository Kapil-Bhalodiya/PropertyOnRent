package com.example.adminservices.Controller;

import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.RoleModel;
import com.example.adminservices.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    RoleService roleservice;

    @GetMapping("/Get")
    public ResponseEntity<List<RoleModel>> GetAllRole() {
        return roleservice.FindAllRole();
    }

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddRole(@RequestBody RoleModel rolemodel) {
        return roleservice.AddRole(rolemodel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateRole(@PathVariable int ID, @RequestBody RoleModel rolemodel) {
        return roleservice.UpdateRole(ID, rolemodel);
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteRole(@PathVariable int ID) {
        return roleservice.DeleteByIDRole(ID);
    }
}
