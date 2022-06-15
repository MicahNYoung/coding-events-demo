package org.launchcode.codingevents.controllers;

<<<<<<< HEAD
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
=======
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/persistent-controller
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/persistent-controller

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

<<<<<<< HEAD
=======
    @Autowired
    private EventRepository eventRepository;
>>>>>>> origin/persistent-controller

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
<<<<<<< HEAD
        model.addAttribute("events", EventData.getAll());
=======
        model.addAttribute("events", eventRepository.findAll());
>>>>>>> origin/persistent-controller
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
<<<<<<< HEAD
=======
        model.addAttribute("types", EventType.values());
>>>>>>> origin/persistent-controller
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
<<<<<<< HEAD
            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }

        EventData.add(newEvent);
=======
            return "events/create";
        }

        eventRepository.save(newEvent);
>>>>>>> origin/persistent-controller
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
<<<<<<< HEAD
        model.addAttribute("events", EventData.getAll());
=======
        model.addAttribute("events", eventRepository.findAll());
>>>>>>> origin/persistent-controller
        return "events/delete";
    }

    @PostMapping("delete")
<<<<<<< HEAD
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds!= null){
            for(int id : eventIds){
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventID}")
    public String displayEditForm(Model model, @PathVariable int eventID) {
        model.addAttribute(EventData.getById(eventID));
        model.addAttribute("title", "Edit Event " + EventData.getById(eventID) + " (id=" + eventID + ")");
        model.addAttribute("events", EventData.getAll());

        return "events/edit";
    }
    @PostMapping("edit")
    public String processEditForm(@RequestParam int eventID, @RequestParam String name, @RequestParam String description) {
        if(name != null) {
            EventData.getById(eventID).setName(name);
        }
        if(description != null) {
            EventData.getById(eventID).setDescription(description);
=======
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
>>>>>>> origin/persistent-controller
        }

        return "redirect:";
    }

}
