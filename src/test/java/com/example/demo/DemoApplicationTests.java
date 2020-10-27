package com.example.demo;

import com.example.demo.Repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DemoApplicationTests {

    @MockBean
    GameRepository gameRepository;

    @Test
    void contextLoads() {
    }
}
