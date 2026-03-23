package com.duoc.peliculas.service;

import com.duoc.peliculas.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    
    private final List<Pelicula> peliculas;

    public PeliculaService() {
        this.peliculas = new ArrayList<>();
        initializeMovies();
    }

    // Initialize movie collection with Studio Ghibli films
    private void initializeMovies() {
        peliculas.add(new Pelicula(1L, "El Viaje de Chihiro", 2001, "Hayao Miyazaki", "Animación", 
            "Una niña de 10 años se adentra en un mundo mágico poblado por espíritus donde debe trabajar para liberar a sus padres de una maldición."));
        
        peliculas.add(new Pelicula(2L, "Mi Vecino Totoro", 1988, "Hayao Miyazaki", "Animación", 
            "Dos hermanas se mudan al campo con su padre y descubren criaturas mágicas del bosque, incluido el amigable Totoro."));
        
        peliculas.add(new Pelicula(3L, "La Princesa Mononoke", 1997, "Hayao Miyazaki", "Animación", 
            "Un joven guerrero busca la cura para una maldición y se ve envuelto en la guerra entre humanos y dioses del bosque."));
        
        peliculas.add(new Pelicula(4L, "El Chico y la Garza", 2023, "Hayao Miyazaki", "Animación", 
            "Un joven encuentra un mundo fantástico a través de una antigua torre después de la muerte de su madre durante la Segunda Guerra Mundial."));
        
        peliculas.add(new Pelicula(5L, "Kiki: Entregas a Domicilio", 1989, "Hayao Miyazaki", "Animación", 
            "Una joven bruja de 13 años se muda a una nueva ciudad para completar su entrenamiento como bruja usando su escoba voladora."));
        
        peliculas.add(new Pelicula(6L, "El Castillo Ambulante", 2004, "Hayao Miyazaki", "Animación", 
            "Una joven convertida en anciana por una maldición busca ayuda del misterioso mago Howl y su castillo ambulante."));
    }

    // Get all movies from the collection
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return new ArrayList<>(peliculas);
    }

    // Find a movie by its ID
    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
        return peliculas.stream()
                .filter(pelicula -> pelicula.getId().equals(id))
                .findFirst();
    }
}