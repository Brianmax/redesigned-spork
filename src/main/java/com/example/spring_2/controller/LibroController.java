package com.example.spring_2.controller;

import com.example.spring_2.entity.LibroEntity;
import com.example.spring_2.repository.LibroRepository;
import com.example.spring_2.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping()
    public List<LibroEntity> findAll() {
        return libroRepository.findAll();
    }
}
