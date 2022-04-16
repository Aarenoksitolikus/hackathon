package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsController {
    @GetMapping
    public String getEvents(Model model) {
        return "events";
    }
}
