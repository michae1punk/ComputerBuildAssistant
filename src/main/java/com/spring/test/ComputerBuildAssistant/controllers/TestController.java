package com.spring.test.ComputerBuildAssistant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class TestController {
    @GetMapping
    public String test(){
        return "TEST";
    }
}
