package com.proyecto.cursos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotNull
    private Integer duracionEnSemanas;

    // tiene un profesor y no puede existir el curso sin el profesor


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracionEnSemanas() {
        return duracionEnSemanas;
    }

    public void setDuracionEnSemanas(Integer duracionEnSemanas) {
        this.duracionEnSemanas = duracionEnSemanas;
    }
}
