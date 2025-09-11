package com.example.spring_2.dto.response;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EditorialResponse {
    private String ruc;
    private String nombre;
    private Date fechaFundacion;
    private String pais;
    private String departamento;
    private String tipo;
    private int numeroTrabajadores;
    private String direccion;
    private String sede;

    public EditorialResponse(String ruc, String nombre, Date fechaFundacion, String pais, String departamento, String tipo, int numeroTrabajadores, String direccion, String sede) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.departamento = departamento;
        this.tipo = tipo;
        this.numeroTrabajadores = numeroTrabajadores;
        this.direccion = direccion;
        this.sede = sede;
    }
}
