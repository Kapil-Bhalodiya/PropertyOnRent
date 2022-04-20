package com.example.adminservices.Controller;

import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Model.StateModel;
import com.example.adminservices.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/State")
public class StateController {

    @Autowired
    StateService stateservice;

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddState(@RequestBody StateModel statemodel)
    {
        return stateservice.SaveState(statemodel);
    }

    @GetMapping("/Get")
    public ResponseEntity<List<StateModel>> GetAllState()
    {
        return stateservice.FindAllState();
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteState(@PathVariable int ID) {return stateservice.DeleteByIDState(ID);}

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateState(@PathVariable int ID, @RequestBody StateModel statemodel) { return stateservice.UpdateState(ID,statemodel);}

}
