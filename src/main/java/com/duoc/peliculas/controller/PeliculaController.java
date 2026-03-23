package com.duoc.peliculas.controller;

import com.duoc.peliculas.model.Pelicula;
import com.duoc.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /**
     * Get all registered movies
     * GET /peliculas
     */
    @GetMapping
    public ResponseEntity<List<Pelicula>> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = peliculaService.obtenerTodasLasPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    /**
     * Get a specific movie by its ID
     * GET /peliculas/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(id);
        
        if (pelicula.isPresent()) {
            return ResponseEntity.ok(pelicula.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}