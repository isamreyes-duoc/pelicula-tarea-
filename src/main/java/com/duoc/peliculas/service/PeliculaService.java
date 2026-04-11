package com.duoc.peliculas.service;

import com.duoc.peliculas.model.Pelicula;
import com.duoc.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    // Obtener todas las películas desde la base de datos Oracle
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    // Buscar una película por su ID en la base de datos Oracle
    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    // Guardar una nueva película en la base de datos Oracle
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Actualizar una película existente en la base de datos Oracle
    public Optional<Pelicula> actualizarPelicula(Long id, Pelicula peliculaActualizada) {
        return peliculaRepository.findById(id).map(pelicula -> {
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setAño(peliculaActualizada.getAño());
            pelicula.setDirector(peliculaActualizada.getDirector());
            pelicula.setGenero(peliculaActualizada.getGenero());
            pelicula.setSinopsis(peliculaActualizada.getSinopsis());
            return peliculaRepository.save(pelicula);
        });
    }

    // Eliminar una película de la base de datos Oracle
    public boolean eliminarPelicula(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}