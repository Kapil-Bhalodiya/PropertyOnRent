package com.example.adminservices.Service;

import com.example.adminservices.Model.PropertyTypeModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.RoleModel;
import com.example.adminservices.Repo.RoleCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleCrud rolecrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<RoleModel>> FindAllRole()
    {
        try
        {
            List<RoleModel> model= rolecrud.findAll();
            responseResult = new ResponseResult(true,false,"All Roles");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> AddRole(RoleModel rolemodel)
    {
        try
        {
            rolecrud.save(rolemodel);
            responseResult = new ResponseResult(true,false,"Role Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,true,"Role Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateRole(int ID, RoleModel rolemodel)
    {
        if(rolecrud.findById(ID).isPresent())
        {
            rolemodel.setRole_id(ID);
            rolecrud.save(rolemodel);
            responseResult = new ResponseResult(true,false,"Role Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This Role not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDRole(int ID)
    {
        if(rolecrud.findById(ID).isPresent())
        {
            rolecrud.deleteById(ID);
            responseResult = new ResponseResult(true,false,"Role Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This Role not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
