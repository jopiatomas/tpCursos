package com.proyecto.cursos.service;


import com.proyecto.cursos.model.Curso;
import com.proyecto.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Optional<Curso> saveCurso(Curso curso){

        return Optional.of(cursoRepository.save(curso));
    }

    public Optional<Curso> getById(Long id){
        return cursoRepository.findById(id);
    }


}
