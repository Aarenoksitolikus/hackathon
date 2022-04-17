package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @GetMapping
    public String getServicesPage(Model model) {
        return "serviceList";
    }

    @GetMapping("/apis")
    public String getApisPage(Model model) {
        return "api";
    }

    @GetMapping("/sites")
    public String getSitesPage(Model model) {
        return "site";
    }
}
