package com.example.spring_2.controller;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.LibroResponse;
import com.example.spring_2.entity.LibroEntity;
import com.example.spring_2.repository.LibroRepository;
import com.example.spring_2.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    private final LibroService libroService;


    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/save")
    public LibroResponse createLibro(@RequestBody LibroCreateRequest request) {
        return libroService.createLibro(request);
    }
}
