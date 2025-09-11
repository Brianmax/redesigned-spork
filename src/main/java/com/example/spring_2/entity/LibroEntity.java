package com.example.spring_2.entity;

import com.example.spring_2.dto.response.AutorResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.from.StandardTableGroup;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class LibroEntity {
    @Id
    private String isbn;
    private String titulo;
    @Column(name = "numero_paginas")
    private int numeroPaginas;
    @Column(name = "anio_publicacion")
    private Date anioPublicacion;
    private String idioma;
    private String categoria;
    private String edicion;
    private String descripcion;
    private Date createdAt;
    private Date updatedAt;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorEntity autorEntity;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private EditorialEntity editorialEntity;
}
