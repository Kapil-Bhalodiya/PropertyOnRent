package com.example.adminservices.Controller;

import com.example.adminservices.Model.EventsModel;
import com.example.adminservices.Model.RequestModel.ResponseResult;
import com.example.adminservices.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Events")
public class EventsController {

    @Autowired
    EventsService eventsservice;

    @GetMapping("/Get")
    public ResponseEntity<List<EventsModel>> GetALlEvents() {
        return eventsservice.FindALlEvents();
    }

    @PostMapping("/Add")
    public ResponseEntity<ResponseResult> AddEvents(@RequestBody EventsModel eventsModel) {
        return eventsservice.SaveEvents(eventsModel);
    }

    @PutMapping("/Edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateEvents(@PathVariable int ID, @RequestBody EventsModel eventsModel) {
        return eventsservice.UpdateEvents(ID, eventsModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteEvents(@PathVariable int ID) {
        return eventsservice.DeleteByIDEvents(ID);
    }
}
