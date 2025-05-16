package com.proyecto.cursos.service;

import com.proyecto.cursos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;



}
