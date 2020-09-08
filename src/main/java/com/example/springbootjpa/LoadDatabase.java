package com.example.springbootjpa;


import com.example.springbootjpa.model.User;
import com.example.springbootjpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            logger.info("Preloading" + userRepository.save(User.builder().name("admin-1").build()));
            logger.info("Preloading" + userRepository.save(User.builder().name("admin-2").build()));
        };
    }

}
