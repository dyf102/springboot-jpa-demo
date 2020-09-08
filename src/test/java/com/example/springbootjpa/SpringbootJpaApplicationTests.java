package com.example.springbootjpa;

import com.example.springbootjpa.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Test
    void contextLoads() {
        assertThat(userController != null);
    }
    @Autowired
    private UserController userController;

}
