package com.example.spring_2.controller;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.LibroResponse;
import com.example.spring_2.entity.LibroEntity;
import com.example.spring_2.repository.LibroRepository;
import com.example.spring_2.service.LibroService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    private final LibroService libroService;


    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public LibroResponse createLibro(@RequestBody LibroCreateRequest request) {
        return libroService.createLibro(request);
    }

    @GetMapping("/find")
    public List<LibroResponse> findLibros(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String direccion,
            @RequestParam String property
    ){
        Sort.Direction sortDirection = Sort.Direction.fromString(direccion);
        return libroService.findLibros(PageRequest.of(page, size, sortDirection, property));
    }
}
