package com.duoc.peliculas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "PELICULAS")
@SequenceGenerator(name = "pelicula_seq", sequenceName = "PELICULA_SEQ", allocationSize = 1)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pelicula_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @JsonProperty("año")
    @Column(name = "ANIO")
    private Integer año;

    @Column(name = "DIRECTOR", length = 100)
    private String director;

    @JsonProperty("genero")
    @Column(name = "GENERO", length = 50)
    private String genero;

    @Column(name = "SINOPSIS", length = 1000)
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, Integer año, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getAño() { return año; }
    public void setAño(Integer año) { this.año = año; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    @Override
    public String toString() {
        return "Pelicula{id=" + id + ", titulo='" + titulo + "', año=" + año +
               ", director='" + director + "', genero='" + genero + "', sinopsis='" + sinopsis + "'}";
    }
}
