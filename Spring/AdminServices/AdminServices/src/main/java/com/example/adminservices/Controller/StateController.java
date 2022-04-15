package com.example.adminservices.Controller;

import com.example.adminservices.Model.StateModel;
import com.example.adminservices.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/State")
public class StateController {

    @Autowired
    StateService stateservice;

    @PostMapping("/Add")
    public StateModel AddState(@RequestBody StateModel statemodel)
    {
        return stateservice.SaveState(statemodel);
    }

    @GetMapping("/Get")
    public Iterable<StateModel> GetAllState()
    {
        return stateservice.FindAllState();
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeleteState(@PathVariable int ID) {return stateservice.DeleteByIDState(ID);}

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateState(@PathVariable int ID,@RequestBody StateModel statemodel) { return stateservice.UpdateState(ID,statemodel);}
}
