package com.campuslands.quiz_uno.config;

import com.campuslands.quiz_uno.bussines.model.Libro;
import com.campuslands.quiz_uno.bussines.service.ServiceLibros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataInitializer implements CommandLineRunner {

    private final ServiceLibros serv;

    public DataInitializer(ServiceLibros serv) {
        this.serv = serv;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Libro> librosIniciales = List.of(
                new Libro("Cien años de soledad", "Gabriel García Márquez", 1967),
                new Libro("El amor en los tiempos del colera", "Gabriel García Márquez", 1985),
                new Libro("La ciudad y los perros", "Mario Vargas Llosa", 1963),
                new Libro("Rayuela", "Julio Cortázar", 1963),
                new Libro("Ficciones", "Jorge Luis Borges", 1944)
        );

        librosIniciales.forEach(serv::registrar);
    }
}
