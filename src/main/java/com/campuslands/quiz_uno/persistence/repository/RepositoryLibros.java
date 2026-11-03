package com.campuslands.quiz_uno.persistence.repository;

import com.campuslands.quiz_uno.bussines.model.Libro;

import java.util.List;
import java.util.Optional;

public interface RepositoryLibros {

    Libro guardar(Libro libro);

    List<Libro> obtenerTodos();

    Optional<Libro> obtenerPorId(Long id);

    Boolean estaRepetido(String titulo, String autor);
}
