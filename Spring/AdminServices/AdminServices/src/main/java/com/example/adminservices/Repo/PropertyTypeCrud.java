package com.example.adminservices.Repo;

import com.example.adminservices.Model.PropertyTypeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PropertyTypeCrud extends CrudRepository<PropertyTypeModel,Integer> {

   /* @Query(name = "select * from propertytype where propertytype_id=?1",nativeQuery = true)
    PropertyTypeModel FindPropertyType(int ID);*/
}
