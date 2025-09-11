package com.example.spring_2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SunatResponse {
    @JsonProperty("razon_social")
    private String razonSocial;
    private String distrito;
    private String departamento;
    private String tipo;
    @JsonProperty("numero_trabajadores")
    private int numeroTrabajadores;
    private String direccion;
}
