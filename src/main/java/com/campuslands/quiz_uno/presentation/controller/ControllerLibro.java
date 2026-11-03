package com.campuslands.quiz_uno.presentation.controller;

import com.campuslands.quiz_uno.bussines.model.Libro;
import com.campuslands.quiz_uno.bussines.service.ServiceLibros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class ControllerLibro {

    private final ServiceLibros serv;

    public ControllerLibro(ServiceLibros serv) {
        this.serv = serv;
    }


    @PostMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Libro registrar(@RequestBody Libro libro) {
        return serv.registrar(libro);
    }

    @GetMapping
    public List<Libro> catalogo() {
        return serv.listar();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return serv.obtenerPorId(id);
    }
}
