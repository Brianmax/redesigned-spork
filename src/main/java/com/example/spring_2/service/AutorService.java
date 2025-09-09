package com.example.spring_2.service;

import com.example.spring_2.dto.AutorCreateRequest;
import com.example.spring_2.entity.AutorEntity;

import java.util.List;

public interface AutorService {
    AutorEntity createAutor(AutorCreateRequest autorRequest);
    List<AutorEntity> getAll();
    AutorEntity findById(String dni);
    AutorEntity updateById(String dni, AutorEntity autorEntity);
    boolean deleteById(String dni);
}
