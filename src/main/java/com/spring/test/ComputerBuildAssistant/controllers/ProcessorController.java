package com.spring.test.ComputerBuildAssistant.controllers;

import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.services.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/processor/")
public class ProcessorController {

    @Autowired
    private ProcessorService service;

    @GetMapping
    public List<Processor> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Processor processor) {
        return service.create(processor);
    }
}
