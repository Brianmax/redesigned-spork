package com.example.spring_2.service;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.LibroResponse;

public interface LibroService {
    LibroResponse createLibro(LibroCreateRequest request);
}
