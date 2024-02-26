package com.spring.test.ComputerBuildAssistant.repositories;

import com.spring.test.ComputerBuildAssistant.entities.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Long> {
}
