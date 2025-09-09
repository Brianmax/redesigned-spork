package com.example.spring_2.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.util.Date;


@Entity
@Table(name = "autor")
public class AutorEntity {
    @Id
    @Column()
    private String dni;
    private String nombre; // setear con la informacion del dni
    @Column(name = "apellido_paterno")
    private String apellidoPaterno; // setear con la informacion del dni
    @Column(name = "apellido_materno")
    private String apellidoMaterno; // setear con la informacion del dni
    @Column(name = "created_at")
    private Date createdAt; // default now
    @Column(name = "updated_at")
    private Date updatedAt; // default null
    @Column(name = "num_libros")
    private int numLibros; // default 0
    private boolean estado; // default true
    private String nacionalidad;
    // usando el dni completar los nombres y apellidos
    //
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }
}
