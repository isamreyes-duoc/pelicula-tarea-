package com.duoc.peliculas.controller;

import com.duoc.peliculas.service.PeliculaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    @Test
    public void testObtenerTodasLasPeliculas() throws Exception {
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerPeliculaPorId() throws Exception {
        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk());
    }
}