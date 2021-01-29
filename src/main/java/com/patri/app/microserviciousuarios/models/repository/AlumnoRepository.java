package com.patri.app.microserviciousuarios.models.repository;

import com.patri.app.microserviciousuarios.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Long> {
}
