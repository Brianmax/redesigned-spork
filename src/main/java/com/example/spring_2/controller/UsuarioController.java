package com.example.spring_2.controller;

import com.example.spring_2.dto.request.LoginRequest;
import com.example.spring_2.dto.request.UsuarioCreateRequest;
import com.example.spring_2.dto.response.UsuarioResponse;
import com.example.spring_2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
@Tag(name = "Usuario controller", description = "Controlador para la creacion y autenticacion de usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public UsuarioResponse createUsuario(@RequestBody UsuarioCreateRequest request) {
        return usuarioService.createUser(request);
    }

    @Operation(summary = "Endpoint para obtener el token de autenticacion")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Token generado satisfactoriamente",
                    content = @Content(mediaType = "text/plain", examples = @ExampleObject("eyJhbGciOiJIUzI1NiJ9.eyJwcnVlYmEyIjo4OTg5LCJwcnVlYmEiOiJFc3RhIGVzIHVuYSBwcnVlYmEgZGUgYWdyZWdhciB1biBjbGFpbSIsInN1YiI6Imdlb3JnZTEyMyIsImlhdCI6MTc1ODMzMzU3NywiZXhwIjoxNzU4MzM0MTc3fQ.vFNJcJy_9dgeOl5Kt1btpS1JTDma3Y5wPxCTl58pOVM"))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Error con usuario o contrasenia"
            )
    })
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest);
    }
}
