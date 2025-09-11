package com.example.spring_2.service;

import com.example.spring_2.dto.request.EditorialCreateRequest;
import com.example.spring_2.dto.response.EditorialResponse;

public interface EditorialService {
    EditorialResponse createEditorial(EditorialCreateRequest request);
}
