package com.spring.test.ComputerBuildAssistant.repositories;

import com.spring.test.ComputerBuildAssistant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
