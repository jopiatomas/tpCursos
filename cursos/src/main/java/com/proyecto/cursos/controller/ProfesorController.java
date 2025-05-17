package com.proyecto.cursos.controller;


import com.proyecto.cursos.model.Profesor;
import com.proyecto.cursos.service.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<?> crearProfesor(@RequestBody @Valid Profesor profesor){
        Optional<Profesor> profesorAux = profesorService.saveProfesor(profesor);

        return ResponseEntity.ok(profesorAux);
    }

    @GetMapping
    public List<Profesor> listarProfesores(){
        return profesorService.listarProfesores();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProfesor(Long id){
        boolean eliminada = profesorService.eliminarProfesor(id);

        if(eliminada){
            return ResponseEntity.ok("Profesor eliminado con exito.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado.");
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<?> modificarProfesor(@PathVariable Long id, @RequestBody Profesor profesor){
        Optional<Profesor> profesorAux = profesorService.actualizarProfesor(id, profesor);

        if(profesorAux.isPresent()){
            return ResponseEntity.ok(profesorAux.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
    }

}
