package com.proyecto.cursos.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // base de datos
    @NotBlank // strings
    private String nombre;

    @Column(nullable = false)
    @NotBlank
    private String apellido;

    @Column(nullable = false, unique = true)
    // también hacer validacion existByEmail() en el repository y usarla al momento de crear
    @Email(message = "El email debe ser valido")
    private String email;

    // one to one la ficha médica

    //@NotNull // todo lo demás

}
