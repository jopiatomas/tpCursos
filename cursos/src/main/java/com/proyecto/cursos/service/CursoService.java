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

    public boolean eliminarCurso(Long id){

        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);

            return true;
        }

        return false;

    }

    public Optional<Curso> actualizarCurso(Long id, Curso nuevoCurso){

        return cursoRepository.findById(id).map(cursoExistente -> {
           cursoExistente.setNombre(nuevoCurso.getNombre());
           cursoExistente.setDuracionEnSemanas(nuevoCurso.getDuracionEnSemanas());

           return cursoRepository.save(cursoExistente);
        });

    }

}
