package com.example.adminservices.Controller;

import com.example.adminservices.Model.EventsModel;
import com.example.adminservices.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Events")
public class EventsController {

    @Autowired
    EventsService eventsservice;

    @GetMapping("/Get")
    public Iterable<EventsModel> GetALlEvents()
    {
        return eventsservice.FindALlEvents();
    }

    @PostMapping("/Add")
    public EventsModel AddEvents(@RequestBody EventsModel eventsModel)
    {
        return  eventsservice.SaveEvents(eventsModel);
    }

    @PutMapping("/Edit/{ID}")
    public Boolean UpdateEvents(@PathVariable int ID,@RequestBody EventsModel eventsModel)
    {
        return eventsservice.UpdateEvents(ID,eventsModel);
    }

    @DeleteMapping("/Delete/{ID}")
    public Boolean DeleteEvents(@PathVariable int ID)
    {
        return eventsservice.DeleteByIDEvents(ID);
    }
}
