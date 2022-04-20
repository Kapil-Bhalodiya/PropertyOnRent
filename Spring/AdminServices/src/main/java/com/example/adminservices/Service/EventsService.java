package com.example.adminservices.Service;

import com.example.adminservices.Model.CityModel;
import com.example.adminservices.Model.EventsModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Repo.EventsCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    EventsCrud eventscrud;

    @Autowired
    ResponseResult responseResult;
    public ResponseEntity<List<EventsModel>> FindALlEvents()
    {
        try
        {
            List<EventsModel> model= eventscrud.findAll();
            responseResult = new ResponseResult(true,false,"All Events");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,true,"No Records Found!");
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<ResponseResult> SaveEvents(EventsModel eventsModel)
    {
        try
        {
            eventscrud.save(eventsModel);
            responseResult = new ResponseResult(true,false,"Events Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,true,"Events Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateEvents(int ID,EventsModel eventsModel)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventsModel.setEvents_id(ID);
            eventscrud.save(eventsModel);
            responseResult = new ResponseResult(true,false,"Event Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This Event not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDEvents(int ID)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventscrud.deleteById(ID);
            responseResult = new ResponseResult(true,false,"Event Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,true,"This Event not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
