package com.utp.cochera.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CocheraControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeRegistrarEntrada() throws Exception {
        mockMvc.perform(post("/api/cochera/entrada")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"placa\":\"ABC123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cerrado").value(false));
    }

    @Test
    void debeConsultarPromocion() throws Exception {
        mockMvc.perform(get("/api/cochera/promocion/XYZ789"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").exists());
    }
}
