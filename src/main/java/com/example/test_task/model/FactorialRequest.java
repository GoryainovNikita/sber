package com.example.test_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FactorialRequest implements Serializable {

    @JsonProperty("factorial_num")
    private Integer value;
}
