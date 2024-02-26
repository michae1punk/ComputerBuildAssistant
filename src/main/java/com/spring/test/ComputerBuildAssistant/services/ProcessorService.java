package com.spring.test.ComputerBuildAssistant.services;

import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.repositories.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorService {

    @Autowired
    private ProcessorRepository repository;

    public List<Processor> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<String> create(Processor processor) {
        repository.save(processor);
        return new ResponseEntity<>("Процессор успешно добавлен", HttpStatus.OK);
    }
}
