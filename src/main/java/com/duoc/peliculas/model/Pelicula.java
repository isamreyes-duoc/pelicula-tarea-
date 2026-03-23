package com.duoc.peliculas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Movie entity representing a film with its basic information
 * Contains Spanish content for JSON responses
 */
public class Pelicula {
    private Long id;
    private String titulo;
    
    @JsonProperty("año")
    private Integer año;
    
    private String director;
    
    @JsonProperty("genero")
    private String genero;
    
    private String sinopsis;

    // Default constructor
    public Pelicula() {
    }

    // Full constructor
    public Pelicula(Long id, String titulo, Integer año, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año=" + año +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}