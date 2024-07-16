package com.alura.Literalura.Control;
import com.alura.Literalura.Servicio.LibroServicio;
import com.alura.Literalura.dto.LibroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ControlLibro {
    @Autowired
    private LibroServicio servicio;

    @GetMapping()
    public List<LibroDto> obtenerTodosLosLibros(){
        return servicio.obtenerTodosLosLibros();
    }
}
