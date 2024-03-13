package com.example.test_task;

import com.example.test_task.model.FactorialRequest;
import com.example.test_task.model.FactorialResponse;
import com.example.test_task.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = TestTaskApplication.class)
@AutoConfigureMockMvc
class TestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Test
    void testPostFactorial() throws Exception {
        FactorialResponse factorialResponse = new FactorialResponse();
        factorialResponse.setValue(120L);
        FactorialRequest factorialRequest = new FactorialRequest();
        factorialRequest.setValue(5);

        Mockito.when(service.createFactorialResponse(120L)).thenReturn(factorialResponse);
        Mockito.when(service.calculateFactorial(5)).thenReturn(120L);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer();

        String content = objectWriter.writeValueAsString(factorialRequest);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/factorial")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(120));
    }

}
