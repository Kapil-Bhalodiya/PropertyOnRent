package com.example.adminservices.Service;

import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.RoleModel;
import com.example.adminservices.Model.StateModel;
import com.example.adminservices.Repo.StateCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@Service
public class StateService {

    @Autowired
    StateCrud statecrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<ResponseResult> SaveState(StateModel statemodel) {
        try
        {
            statecrud.save(statemodel);
            responseResult = new ResponseResult(true,false,"State Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,true,"This State not exist!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateState(int ID,StateModel statemodel)
    {
        if(statecrud.findById(ID).isPresent())
        {
            statemodel.setState_id(ID);
            statecrud.save(statemodel);
            responseResult = new ResponseResult(true,false,"State Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This State not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<List<StateModel>> FindAllState() {
        try
        {
            List<StateModel> model= statecrud.findAll();
            responseResult = new ResponseResult(true,false,"All State");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<ResponseResult> DeleteByIDState(int ID) {

        if(statecrud.findById(ID).isPresent()) {
            statecrud.deleteById(ID);
            responseResult = new ResponseResult(true,false,"State Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This State not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}

