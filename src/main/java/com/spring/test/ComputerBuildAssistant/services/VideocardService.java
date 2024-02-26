package com.spring.test.ComputerBuildAssistant.services;

import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.entities.Videocard;
import com.spring.test.ComputerBuildAssistant.repositories.VideocardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideocardService {

    @Autowired
    private VideocardRepository repository;

    public List<Videocard> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<String> create(Videocard videocard) {
        repository.save(videocard);
        return new ResponseEntity<>("Видеокарта успешно добавлена", HttpStatus.OK);
    }
}
