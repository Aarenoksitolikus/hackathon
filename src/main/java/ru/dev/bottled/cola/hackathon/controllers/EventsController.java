package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dev.bottled.cola.hackathon.security.details.UserDetailsImpl;
import ru.dev.bottled.cola.hackathon.services.templates.EventsService;

@Controller
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public String getEvents(Model model) {
        return "events";
    }

    @GetMapping("/hackathon")
    public String getHackathon() {
        return "firstEvent";
    }

    @GetMapping("/mirakh")
    public String getMirakh() {
        return "art";
    }

    @GetMapping("/aralashu")
    public String getChatPage(Model model) {
        return "aralashu";
    }

    @GetMapping("/kamal")
    public String getKamal() {
        return "theatre";
    }

    @GetMapping("/intellectual")
    public String getIntellectual() {
        return "intelligence";
    }

    @PostMapping("/{id}")
    public Integer likeEvent(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        var user = userDetails.getUser();
        return eventsService.updateLikesCount(id, user.getId());
    }
}
