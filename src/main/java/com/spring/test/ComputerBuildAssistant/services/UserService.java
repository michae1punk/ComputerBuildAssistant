package com.spring.test.ComputerBuildAssistant.services;

import com.spring.test.ComputerBuildAssistant.entities.User;
import com.spring.test.ComputerBuildAssistant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<String> create(User user) {
        if (repository.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>("Юзер с таким юзернеймом уже существует", HttpStatus.BAD_REQUEST);
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity<>("Пользователь создан.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> restorePassword(User user) {
        User old = repository.findByUsername(user.getUsername());
        if (old == null) {
            return new ResponseEntity<>("Пользователя с таким именем не существует.", HttpStatus.BAD_REQUEST);
        }
        String password = createPassword();
        old.setPassword(password);
        repository.save(old);
        return new ResponseEntity<>("Ваш новый пароль: " + password, HttpStatus.OK);
    }

    private String createPassword() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public User getAdmin() {
        return repository.findById(1L).get();
    }

    public ResponseEntity<String> auth(User user) {
        User old = repository.findByUsername(user.getUsername());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodePassword = passwordEncoder.encode(user.getPassword());
        if (old == null) {
            return new ResponseEntity<>("Пользователя с таким именем не существует.", HttpStatus.BAD_REQUEST);
        }
        else if (!old.getPassword().equals(encodePassword)) {
            return new ResponseEntity<>("Неправильный пароль.", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Добро пожаловать!", HttpStatus.OK);

        }
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
