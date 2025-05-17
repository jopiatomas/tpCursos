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


    public Optional<Alumno> saveAlumno(Alumno alumno) {
        // acá hay que corroborar que el mail no exista

        return Optional.of(alumnoRepository.save(alumno));
    }

    public Optional<Alumno> getById(Long id) {

        return alumnoRepository.findById(id);
    }

    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> actualizarAlumno(Long id, Alumno nuevoAlumno) {
        return alumnoRepository.findById(id).map(alumnoExistente -> {
            alumnoExistente.setNombre(nuevoAlumno.getNombre());
            alumnoExistente.setApellido(nuevoAlumno.getApellido());
            alumnoExistente.setEmail(nuevoAlumno.getEmail());

            return alumnoRepository.save(alumnoExistente);
        });
    }

    public boolean eliminarAlumno(Long id){
        if(alumnoRepository.existsById(id)){
            alumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
