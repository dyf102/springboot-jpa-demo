package com.example.springbootjpa.repository;

import com.example.springbootjpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //List<User> findByNameOrCreateTimeDesc(String name);
}
