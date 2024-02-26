package com.spring.test.ComputerBuildAssistant.services;

import com.spring.test.ComputerBuildAssistant.controllers.MotherboardController;
import com.spring.test.ComputerBuildAssistant.entities.Motherboard;
import com.spring.test.ComputerBuildAssistant.entities.Processor;
import com.spring.test.ComputerBuildAssistant.repositories.MotherboardRepository;
import com.spring.test.ComputerBuildAssistant.repositories.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherboardService {

    @Autowired
    private MotherboardRepository repository;
    @Autowired
    private ProcessorRepository processorRepository;

    public List<Motherboard> getAll(String socket) {
        if (socket != null) {
           return repository.findBySocket(socket);
        }
        return repository.findAll();
    }

    public ResponseEntity<String> create(Motherboard motherboard) {
        repository.save(motherboard);
        return new ResponseEntity<>("Материнская плата успешно добавлена", HttpStatus.OK);
    }

    public List<Motherboard> getSuitableByProcessorId(Long processorId) {
        Processor processor = processorRepository.findById(processorId)
                .orElseThrow(() -> new IllegalArgumentException("Не найден процессор с таким id."));
        return repository.findBySocket(processor.getSocket());
    }
}
