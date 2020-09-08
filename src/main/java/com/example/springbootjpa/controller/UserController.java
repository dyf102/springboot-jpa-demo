package com.example.springbootjpa.controller;

import com.example.springbootjpa.model.User;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    @Autowired
    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return (List<User>) repository.findAll();
    }

    @PostMapping("/user")
    User newUser(User user) {
        return repository.save(user);
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("user id is not found"));
    }

    @PutMapping("/user/{id}")
    User replaceUser(@PathVariable Long id, @RequestBody User user) {
        return repository.findById(id).map((oldUser) -> {
            oldUser.setName(user.getName());
            return repository.save(oldUser);
        }).orElseGet(() -> {
            user.setId(id);
            return repository.save(user);
        }
        );
    }
}
