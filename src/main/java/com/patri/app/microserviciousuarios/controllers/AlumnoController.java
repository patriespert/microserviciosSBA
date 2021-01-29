package com.patri.app.microserviciousuarios.controllers;

import com.patri.app.microserviciousuarios.models.entity.Alumno;
import com.patri.app.microserviciousuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> verDetalles(@PathVariable Long id){

        Optional<Alumno> o = service.findById(id);

        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){

        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> editar(@RequestBody Alumno alumno, @PathVariable Long id){

        Optional <Alumno> o = service.findById(id);

        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = o.get();

        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
