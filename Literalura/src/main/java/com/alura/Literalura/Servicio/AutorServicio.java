package com.alura.Literalura.Servicio;

import com.alura.Literalura.Repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import com.alura.Literalura.dto.AutorDto;
import com.alura.Literalura.modelo.Autor;
import com.alura.Literalura.Repositorio.AutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class AutorServicio {
    @Autowired
    private AutorRepositorio repository;

    // Método para obtener todos los autores y convertirlos en DTO
    public List<AutorDto> obtenerTodosLosAutores() {
        // Obtiene todos los autores de la base de datos utilizando el repositorio
        List<Autor> autores = repository.findAll();
        // Convierte la lista de autores en una lista de DTO de autores utilizando el método convierteDatos
        return convierteDatos(autores);
    }

    // Método para convertir una lista de autores en una lista de DTO de autores
    public List<AutorDto> convierteDatos(List<Autor> autores) {
        // Utiliza stream y map para convertir cada autor en un DTO de autor y luego los recopila en una lista
        return autores.stream()
                .map(a -> new AutorDto(
                        a.getId(),
                        a.getNombre(),
                        a.getFechaNacimiento(),
                        a.getFechaFallecimiento()
                ))
                .collect(Collectors.toList());
    }
}
