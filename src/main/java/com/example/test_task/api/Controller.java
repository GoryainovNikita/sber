package com.example.test_task.api;

import com.example.test_task.model.FactorialRequest;
import com.example.test_task.model.FactorialResponse;
import com.example.test_task.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factorial")
@RequiredArgsConstructor
public class Controller {


    private final Service service;


    @PostMapping
    public FactorialResponse factorial(@RequestBody FactorialRequest factorialRequest){
        return service.createFactorialResponse(service.calculateFactorial(factorialRequest.getValue()));
    }
}
