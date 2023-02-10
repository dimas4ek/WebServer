package com.practice.webserver.controllers;

import com.practice.webserver.service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GPSController {
    private final GPSService gpsService;

    @Autowired
    public GPSController(GPSService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping("/gpsLocation")
    public String getLocation(Model model) {
        model.addAttribute("getLocation", gpsService.getLocation());
        return "gps/gpsLocation";
    }
}
