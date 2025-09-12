package com.example.spring_2.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.from.StandardTableGroup;

import java.util.Date;
@Getter
@Setter
public class LibroResponse {
    private String isbn;
    private String titulo;
    private Date anioPublicacion;
    private String idioma;
    private String categoria;
    private String edicion;
    private String descripcion;
    private InfoAutorResponse infoAutorResponse;
    private String editorial;
}
