package com.campuslands.quiz_uno.persistence.repository;

import com.campuslands.quiz_uno.bussines.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryLibrosEnMemoria implements RepositoryLibros{

    List<Libro> libros = new ArrayList<>();
    private Long siguienteId = 1L;

    @Override
    public Libro guardar(Libro libro) {
        libro.setId(siguienteId++);
        libros.add(libro);
        return libro;
    }

    @Override
    public List<Libro> obtenerTodos() {
        return libros;
    }

    @Override
    public Optional<Libro> obtenerPorId(Long id) {
        return libros.stream()
                .filter(libro -> libro.getId().equals(id))
                .findFirst();
    }

    @Override
    public Boolean estaRepetido(String titulo, String autor) {
        return libros.stream()
                .anyMatch(libro -> libro.getTitulo().equalsIgnoreCase(titulo)
                && libro.getAutor().equalsIgnoreCase(autor));
    }
}
