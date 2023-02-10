package com.practice.webserver.controllers;

import com.practice.webserver.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GpsController {
    private final GpsService gpsService;

    @Autowired
    public GpsController(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping("/gpsLocation")
    public String getLocation(Model model) {
        model.addAttribute("getLocation", gpsService.getLocation());
        return "gps/gpsLocation";
    }
}
