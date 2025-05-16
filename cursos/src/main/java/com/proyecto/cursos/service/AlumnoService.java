package com.proyecto.cursos.service;

import com.proyecto.cursos.model.Alumno;
import com.proyecto.cursos.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    public Optional<Alumno> saveAlumno(Alumno alumno){
        // acá hay que corroborar que el mail no exista

        return Optional.of(alumnoRepository.save(alumno));
    }

    public Optional<Alumno> getById(Long id){

        return alumnoRepository.findById(id);
    }

    public List<Alumno> getAll(){
        return alumnoRepository.findAll();
    }

}
