package com.example.adminservices.Repo;

import com.example.adminservices.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleCrud extends JpaRepository<RoleModel,Integer>
{

}
