package com.campuslands.quiz_uno.bussines.service;


import com.campuslands.quiz_uno.bussines.model.Libro;
import com.campuslands.quiz_uno.persistence.repository.RepositoryLibros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceLibros {

    private final RepositoryLibros repo;

    public ServiceLibros(RepositoryLibros repo) {
        this.repo = repo;
    }

    public Libro registrar(Libro libro) {
        if (repo.estaRepetido(libro.getTitulo(), libro.getAutor())) {
            throw new IllegalArgumentException("Ya fue registrado este libro");
        }

        return repo.guardar(libro);
    }

    public List<Libro> listar() {
        return repo.obtenerTodos();
    }

    public Libro obtenerPorId(Long id) {
        return repo.obtenerPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No existe el libro " + id));
    }
}
