package org.example.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VacationCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateVacationPayment() throws Exception {
        mockMvc.perform(get("/calculate")
                        .param("averageSalary", "1000")
                        .param("vacationDays", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("20000"));
    }


}