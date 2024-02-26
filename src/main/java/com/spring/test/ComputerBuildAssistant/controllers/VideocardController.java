package com.spring.test.ComputerBuildAssistant.controllers;

import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.entities.Videocard;
import com.spring.test.ComputerBuildAssistant.services.VideocardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/videocard/")
public class VideocardController {

    @Autowired
    private VideocardService service;

    @GetMapping
    public List<Videocard> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Videocard videocard) {
        return service.create(videocard);
    }
}
