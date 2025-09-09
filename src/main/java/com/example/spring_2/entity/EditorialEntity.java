package com.example.spring_2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name = "editorial")
@Entity
@Getter
@Setter
public class EditorialEntity {
    @Id
    private String ruc;
    private String nombre; // razon social
    @Column(name = "fecha_fundacion")
    private Date fechaFundacion;
    private String pais; // default Peru
    private String sede; // Distrito
    private String departamento; // departamento
    private String tipo; // tipo
    @Column(name = "numero_trabajadores")
    private int numeroTrabajadores; // numero_trabajadores
    private String direccion; //direccion
    private boolean estado; // default true
}
