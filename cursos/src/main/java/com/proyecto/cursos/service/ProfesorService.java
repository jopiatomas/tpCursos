package com.proyecto.cursos.service;

import com.proyecto.cursos.model.Profesor;
import com.proyecto.cursos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Optional<Profesor> saveProfesor(Profesor profesor) {

        // agregar validaciones (creo)

        return Optional.of(profesorRepository.save(profesor));
    }

    public List<Profesor> listarProfesores() {

        return profesorRepository.findAll();
    }

    public Optional<Profesor> getById(Long id) {

        return profesorRepository.findById(id);
    }

    public boolean eliminarProfesor(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public Optional<Profesor> actualizarProfesor(Long id, Profesor profesorNuevo){
        return profesorRepository.findById(id).map(profesorExistente -> {
            profesorExistente.setNombre(profesorNuevo.getNombre());
            return profesorRepository.save(profesorNuevo);
        });
    }

}
