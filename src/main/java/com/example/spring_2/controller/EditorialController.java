package com.example.spring_2.controller;

import com.example.spring_2.dto.request.EditorialCreateRequest;
import com.example.spring_2.dto.response.EditorialResponse;
import com.example.spring_2.service.EditorialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/editorial")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @PostMapping
    public EditorialResponse createEditorial(@RequestBody EditorialCreateRequest editorialCreateRequest) {
        return editorialService.createEditorial(editorialCreateRequest);
    }
}
