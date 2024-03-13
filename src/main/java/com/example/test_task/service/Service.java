package com.example.test_task.service;

import com.example.test_task.model.FactorialResponse;

@org.springframework.stereotype.Service
public class Service {

    public Long calculateFactorial(int value){
        if(value > 20){
            throw new IllegalArgumentException("Value too high");
        }
        if (value <= 1) {
            return 1L;
        }
        else {
            return value * calculateFactorial(value - 1);
        }
    }

    public FactorialResponse createFactorialResponse(Long l){
        FactorialResponse factorialResponse = new FactorialResponse();
        factorialResponse.setValue(l);
        return factorialResponse;
    }
}
