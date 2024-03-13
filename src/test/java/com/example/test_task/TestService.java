package com.example.test_task;

import com.example.test_task.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestTaskApplication.class)
public class TestService {

    @Autowired
    public Service service;

    @Test
    public void calculateFactorialTest(){

        assertEquals(service.calculateFactorial(5), 120);
        assertEquals(service.calculateFactorial(0), 1);
        assertThrows(IllegalArgumentException.class, () -> service.calculateFactorial(21));

    }


}
