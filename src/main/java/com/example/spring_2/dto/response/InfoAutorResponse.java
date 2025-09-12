package com.example.spring_2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InfoAutorResponse {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public InfoAutorResponse(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
}
