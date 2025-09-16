package com.example.spring_2.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private int userId;
    private String username;
    private String role;
}
