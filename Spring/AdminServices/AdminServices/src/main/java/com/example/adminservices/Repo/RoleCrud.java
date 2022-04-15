package com.example.adminservices.Repo;

import com.example.adminservices.Model.RoleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleCrud extends CrudRepository<RoleModel,Integer>
{
   /* @Query(value = "select * from role where role_id=?",nativeQuery = true)
    RoleModel FindRole(int ID);*/
}
