package com.example.spring_2.controller;

import com.example.spring_2.dto.request.AutorCreateRequest;
import com.example.spring_2.dto.response.AutorResponse;
import com.example.spring_2.entity.AutorEntity;
import com.example.spring_2.service.AutorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
    @PostMapping("/save")
    public AutorEntity createAutorController(@RequestBody AutorCreateRequest autorRequest) {
        return autorService.createAutor(autorRequest);
    }

    @GetMapping("find/{id}")
    public AutorResponse findByIdAutor(@PathVariable String id) {
        return autorService.findById(id);
    }
}
