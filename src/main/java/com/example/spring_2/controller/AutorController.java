package com.example.spring_2.controller;

import com.example.spring_2.dto.request.AutorCreateRequest;
import com.example.spring_2.dto.response.AutorResponse;
import com.example.spring_2.entity.AutorEntity;
import com.example.spring_2.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/autor")
@Tag(name = "Autor Controller", description = "Controlador usado para manejar el create y el find de los autores")
public class AutorController {
    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @Operation( summary = "Crear un autor en la base de datos")
    @PostMapping("/save")
    public AutorEntity createAutorController(@RequestBody AutorCreateRequest autorRequest) {
        return autorService.createAutor(autorRequest);
    }

    @GetMapping("find/{id}")
    public AutorResponse findByIdAutor(@PathVariable String id) {
        return autorService.findById(id);
    }
}
