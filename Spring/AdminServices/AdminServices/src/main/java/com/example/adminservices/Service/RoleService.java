package com.example.adminservices.Service;

import com.example.adminservices.Model.RoleModel;
import com.example.adminservices.Repo.RoleCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleCrud rolecrud;

    public Iterable<RoleModel> FindAllRole()
    {
        return rolecrud.findAll();
    }

    public RoleModel AddRole(RoleModel rolemodel)
    {
        return rolecrud.save(rolemodel);
    }

    public Boolean UpdateRole(int ID, RoleModel rolemodel)
    {
        if(rolecrud.findById(ID).isPresent())
        {
            rolemodel.setRole_id(ID);
            rolecrud.save(rolemodel);
            return true;
        }
        return false;
    }

    public Boolean DeleteByIDRole(int ID)
    {
        if(rolecrud.findById(ID).isPresent())
        {
            rolecrud.deleteById(ID);
            return true;
        }
        return false;
    }

}
