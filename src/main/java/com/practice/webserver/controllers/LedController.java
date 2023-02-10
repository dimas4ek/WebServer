package com.practice.webserver.controllers;

import com.practice.webserver.service.LedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LedController {

    private final LedService ledService;

    @Autowired
    public LedController(LedService ledService) {
        this.ledService = ledService;
    }

    @GetMapping("ledControl")
    public String index() {
        return "led/ledControl";
    }

    @GetMapping("/turnOn")
    public String turnOn() {
        ledService.turnOn();
        return "redirect:/ledControl";
    }

    @GetMapping("/turnOff")
    public String turnOff() {
        ledService.turnOff();
        return "redirect:/ledControl";
    }
}