package com.alura.Literalura.dto;
import com.alura.Literalura.modelo.Autor;

public record LibroDto(Long Id,
                       String titulo,
                       Autor autor,
                       String idioma,
                       Double descargas) {
}
