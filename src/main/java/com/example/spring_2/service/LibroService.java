package com.example.spring_2.service;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.LibroResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibroService {
    LibroResponse createLibro(LibroCreateRequest request);
    List<LibroResponse> findLibros(Pageable pageable);
}
