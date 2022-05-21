package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {
    private static List<String> events = new ArrayList<>();
//    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {

//    model.addAttribute("events", events);
//    return "events/index";

       events.put("Gamer Coders 4 Life", "You Already Know Bro");
        events.put("Female Coders 4 Life", "You Already Know Broette");
        events.put("Animal Coders 4 Life", "You Already Know Animal?");
        System.out.println(events);
        model.addAttribute("events", events);
        return "events/index";
}

//lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    //BROKEN: Data binding not working. Template is being generated, but not filled with data.
    @GetMapping("events-with-description")
    public String renderEventsWithDescription() {
        return "events/events-with-description";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription){
        events.put(eventName, eventDescription);
        return "redirect:/events";
    }


}
