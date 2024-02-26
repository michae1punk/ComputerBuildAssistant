package com.spring.test.ComputerBuildAssistant.controllers;

import com.spring.test.ComputerBuildAssistant.entities.User;
import com.spring.test.ComputerBuildAssistant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="admin/")
    public User getAdmin() {
        return userService.getAdmin();
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return userService.auth(user);
    }

    @PutMapping
    public ResponseEntity<String> restorePassword(@RequestBody User user) {
        return userService.restorePassword(user);
    }
}
