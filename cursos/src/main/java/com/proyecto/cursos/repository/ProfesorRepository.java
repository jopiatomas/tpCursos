package com.proyecto.cursos.repository;

import com.proyecto.cursos.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
