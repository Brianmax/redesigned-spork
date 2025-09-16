package com.example.spring_2.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateRequest {
    private String username;
    private String password;
    private String role;
}
