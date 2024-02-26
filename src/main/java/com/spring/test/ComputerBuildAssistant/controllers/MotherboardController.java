package com.spring.test.ComputerBuildAssistant.controllers;

import com.spring.test.ComputerBuildAssistant.entities.Motherboard;
import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.services.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/motherboard/")
public class MotherboardController {

    @Autowired
    private MotherboardService service;

    @GetMapping
    public List<Motherboard> getAll(@RequestParam(name = "socket", required = false) String socket){
        return service.getAll(socket);
    }

    @GetMapping(path = "{processor_id}/find_suitable_by_processor")
    public List<Motherboard> getSuitableByProcessorId(@PathVariable(name = "processor_id") Long processorId) {
        return service.getSuitableByProcessorId(processorId);
    }


    @PostMapping
    public ResponseEntity<String> create(@RequestBody Motherboard motherboard) {
        return service.create(motherboard);
    }
}
