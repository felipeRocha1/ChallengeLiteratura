package com.alura.Literalura.Servicio;
import com.alura.Literalura.dto.LibroDto;
import com.alura.Literalura.modelo.Libro;
import com.alura.Literalura.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio repository;

    // Método para obtener todos los libros y convertirlos a LibroDTO
    public List<LibroDto> obtenerTodosLosLibros() {

        return convierteDatos(repository.findAll());
    }

    // Método para convertir una lista de libros a una lista de LibroDTO
    public List<LibroDto> convierteDatos(List<Libro> libro) {
        return libro.stream()
                .map(l -> new LibroDto(
                        l.getId(),
                        l.getTitulo(),
                        l.getAutor(),
                        l.getIdioma(),
                        l.getDescargas()
                ))
                .collect(Collectors.toList());
    }
}