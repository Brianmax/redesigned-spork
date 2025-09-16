package com.example.spring_2.service;

import com.example.spring_2.dto.request.UsuarioCreateRequest;
import com.example.spring_2.dto.response.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse createUser(UsuarioCreateRequest usuarioCreateRequest);
}
