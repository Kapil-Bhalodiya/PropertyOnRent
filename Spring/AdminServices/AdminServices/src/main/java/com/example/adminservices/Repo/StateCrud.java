package com.example.adminservices.Repo;

import com.example.adminservices.Model.StateModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StateCrud extends CrudRepository<StateModel,Integer> {

   /* @Query(value = "select * from state where state_id = ?",nativeQuery = true)
    StateModel findState(int ID);*/

}
