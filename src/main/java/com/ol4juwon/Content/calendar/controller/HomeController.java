package com.ol4juwon.Content.calendar.controller;

import com.ol4juwon.Content.calendar.config.CCProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    private final CCProperties properties;

    public HomeController(CCProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public CCProperties home(){
        return properties;
    }
}
