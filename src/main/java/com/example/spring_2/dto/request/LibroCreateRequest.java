package com.example.spring_2.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class LibroCreateRequest {
    private String isbn;
    private String titulo;
    private int numeroPaginas;
    private Date anioPublicacion;
    private String idioma;
    private String categoria;
    private String edicion;
    private String descripcion;
    private String autorId;
    private String editorialId;
}
