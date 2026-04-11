package com.duoc.peliculas.controller;

import com.duoc.peliculas.model.Pelicula;
import com.duoc.peliculas.service.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testObtenerTodasLasPeliculas() throws Exception {
        List<Pelicula> peliculas = Arrays.asList(
            new Pelicula(1L, "El Viaje de Chihiro", 2001, "Hayao Miyazaki", "Animacion", "Una nina y el mundo magico."),
            new Pelicula(2L, "Mi Vecino Totoro", 1988, "Hayao Miyazaki", "Animacion", "Dos hermanas y criaturas magicas.")
        );
        when(peliculaService.obtenerTodasLasPeliculas()).thenReturn(peliculas);

        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].titulo").value("El Viaje de Chihiro"));
    }

    @Test
    public void testObtenerPeliculaPorId_Encontrada() throws Exception {
        Pelicula pelicula = new Pelicula(1L, "El Viaje de Chihiro", 2001, "Hayao Miyazaki", "Animacion", "Una nina y el mundo magico.");
        when(peliculaService.obtenerPeliculaPorId(1L)).thenReturn(Optional.of(pelicula));

        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El Viaje de Chihiro"))
                .andExpect(jsonPath("$.director").value("Hayao Miyazaki"));
    }

    @Test
    public void testObtenerPeliculaPorId_NoEncontrada() throws Exception {
        when(peliculaService.obtenerPeliculaPorId(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/peliculas/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCrearPelicula() throws Exception {
        Pelicula nueva = new Pelicula(null, "Inception", 2010, "Christopher Nolan", "Ciencia Ficcion",
                "Un ladron que roba secretos a traves del sueno.");
        Pelicula guardada = new Pelicula(7L, "Inception", 2010, "Christopher Nolan", "Ciencia Ficcion",
                "Un ladron que roba secretos a traves del sueno.");
        when(peliculaService.guardarPelicula(any(Pelicula.class))).thenReturn(guardada);

        mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nueva)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(7))
                .andExpect(jsonPath("$.titulo").value("Inception"));
    }

    @Test
    public void testActualizarPelicula_Encontrada() throws Exception {
        Pelicula actualizada = new Pelicula(null, "Inception Actualizada", 2010, "Christopher Nolan",
                "Ciencia Ficcion", "Descripcion actualizada.");
        Pelicula resultado = new Pelicula(1L, "Inception Actualizada", 2010, "Christopher Nolan",
                "Ciencia Ficcion", "Descripcion actualizada.");
        when(peliculaService.actualizarPelicula(eq(1L), any(Pelicula.class))).thenReturn(Optional.of(resultado));

        mockMvc.perform(put("/peliculas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Inception Actualizada"));
    }

    @Test
    public void testActualizarPelicula_NoEncontrada() throws Exception {
        Pelicula actualizada = new Pelicula(null, "X", 2000, "Y", "Z", "W");
        when(peliculaService.actualizarPelicula(eq(99L), any(Pelicula.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/peliculas/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizada)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testEliminarPelicula_Encontrada() throws Exception {
        when(peliculaService.eliminarPelicula(1L)).thenReturn(true);

        mockMvc.perform(delete("/peliculas/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testEliminarPelicula_NoEncontrada() throws Exception {
        when(peliculaService.eliminarPelicula(99L)).thenReturn(false);

        mockMvc.perform(delete("/peliculas/99"))
                .andExpect(status().isNotFound());
    }
}
