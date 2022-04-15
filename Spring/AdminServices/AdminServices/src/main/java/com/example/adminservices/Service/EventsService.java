package com.example.adminservices.Service;

import com.example.adminservices.Model.EventsModel;
import com.example.adminservices.Repo.EventsCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {

    @Autowired
    EventsCrud eventscrud;
    public Iterable<EventsModel> FindALlEvents()
    {
        return eventscrud.findAll();
    }

    public EventsModel SaveEvents(EventsModel eventsModel)
    {
        return eventscrud.save(eventsModel);
    }

    public Boolean UpdateEvents(int ID,EventsModel eventsModel)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventsModel.setEvents_id(ID);
            eventscrud.save(eventsModel);
            return true;
        }
        return false;
    }

    public Boolean DeleteByIDEvents(int ID)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventscrud.deleteById(ID);
            return true;
        }
        return false;
    }

}
