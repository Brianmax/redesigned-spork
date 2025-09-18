package com.example.spring_2.controller;

import com.example.spring_2.dto.request.LoginRequest;
import com.example.spring_2.dto.request.UsuarioCreateRequest;
import com.example.spring_2.dto.response.UsuarioResponse;
import com.example.spring_2.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public UsuarioResponse createUsuario(@RequestBody UsuarioCreateRequest request) {
        return usuarioService.createUser(request);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest);
    }
}
