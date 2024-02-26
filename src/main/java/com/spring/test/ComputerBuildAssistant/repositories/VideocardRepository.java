package com.spring.test.ComputerBuildAssistant.repositories;

import com.spring.test.ComputerBuildAssistant.entities.Videocard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideocardRepository extends JpaRepository<Videocard, Long> {
}
