package com.utp.cochera.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utp.cochera.model.Vehiculo;
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
class VehiculoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void debeListarVehiculos() throws Exception {
        mockMvc.perform(get("/api/vehiculos"))
                .andExpect(status().isOk());
    }

    @Test
    void debeCrearVehiculo() throws Exception {
        Vehiculo vehiculo = new Vehiculo("QWE456", "Luis Perez", "Auto");

        mockMvc.perform(post("/api/vehiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehiculo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.placa").value("QWE456"));
    }
}
