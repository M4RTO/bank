package com.automatic.bank.adapter.controller;

import com.automatic.bank.MockFactory;
import com.automatic.bank.application.in.GetMovementsPortIn;
import com.automatic.bank.config.exception.MovementsNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Bank Controller adapter")
@WebMvcTest(BankControllerAdapter.class)
public class BankControllerAdapterTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetMovementsPortIn getMovementsPortIn;

    private static final String URL= "/api/v1/banks";

    @Test
    void getAllMovements() throws Exception {
        final var expected =
                objectMapper.writeValueAsString(MockFactory.getMovementsResponse());

        when(getMovementsPortIn.execute(any(),any()))
                .thenReturn(MockFactory.getMovementsEntity());

        mockMvc.perform(get(URL + "/1?type=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("When I get all movements must be thrown exception because there are an exception")
    void getMovementsException() throws Exception {

        when(getMovementsPortIn.execute(any(),any()))
                .thenThrow(new MovementsNotFoundException("Not Found Movements with these params"));

        mockMvc.perform(get(URL + "/1?type=1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
