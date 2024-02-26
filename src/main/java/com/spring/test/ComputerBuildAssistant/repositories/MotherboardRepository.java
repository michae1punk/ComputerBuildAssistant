package com.spring.test.ComputerBuildAssistant.repositories;

import com.spring.test.ComputerBuildAssistant.entities.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    List<Motherboard> findBySocket(String socket);
}
