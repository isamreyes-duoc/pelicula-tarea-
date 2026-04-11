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

    /**
     * Create a new movie
     * POST /peliculas
     */
    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nueva = peliculaService.guardarPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    /**
     * Update an existing movie by its ID
     * PUT /peliculas/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id,
                                                       @RequestBody Pelicula peliculaActualizada) {
        Optional<Pelicula> resultado = peliculaService.actualizarPelicula(id, peliculaActualizada);

        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Delete a movie by its ID
     * DELETE /peliculas/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        boolean eliminada = peliculaService.eliminarPelicula(id);

        if (eliminada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}