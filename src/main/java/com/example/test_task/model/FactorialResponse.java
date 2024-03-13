package com.example.test_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FactorialResponse implements Serializable {

    @JsonProperty("result")
    private Long value;
}
