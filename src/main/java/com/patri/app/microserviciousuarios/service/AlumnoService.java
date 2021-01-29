package com.patri.app.microserviciousuarios.service;


import com.patri.app.microserviciousuarios.models.entity.Alumno;

import java.util.Optional;

public interface AlumnoService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
}
