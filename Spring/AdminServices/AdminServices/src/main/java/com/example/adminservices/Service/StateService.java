package com.example.adminservices.Service;

import com.example.adminservices.Model.StateModel;
import com.example.adminservices.Repo.StateCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    StateCrud statecrud;

    public StateModel SaveState(StateModel statemodel) {
        return statecrud.save(statemodel);
    }

    public Boolean UpdateState(int ID,StateModel statemodel)
    {
        if(statecrud.findById(ID).isPresent())
        {
            statemodel.setState_id(ID);
            statecrud.save(statemodel);
            return true;
        }
        return false;
    }

    public Iterable<StateModel> FindAllState() {
        return statecrud.findAll();
    }

    public boolean DeleteByIDState(int ID) {

        if(statecrud.findById(ID).isPresent()) {
            statecrud.deleteById(ID);
            return true;
        }
        return false;
    }
}

