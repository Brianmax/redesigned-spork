package com.example.spring_2.service.impl;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.AutorResponse;
import com.example.spring_2.dto.response.LibroResponse;
import com.example.spring_2.entity.AutorEntity;
import com.example.spring_2.entity.EditorialEntity;
import com.example.spring_2.entity.LibroEntity;
import com.example.spring_2.repository.AutorRepository;
import com.example.spring_2.repository.EditorialRepository;
import com.example.spring_2.repository.LibroRepository;
import com.example.spring_2.service.LibroService;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final EditorialRepository editorialRepository;

    public LibroServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository, EditorialRepository editorialRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.editorialRepository = editorialRepository;
    }

    @Override
    public LibroResponse createLibro(LibroCreateRequest request) {
        String isbn = request.getIsbn();
        String dniAutor = request.getAutorId();
        String rucEditorial = request.getEditorialId();

        AutorEntity autorBd = autorRepository.findById(dniAutor).orElse(null);
        EditorialEntity editorialBd = editorialRepository.findById(rucEditorial).orElse(null);

        if (libroRepository.existsById(isbn) || autorBd == null || editorialBd == null) {
            return null;
        }

        LibroEntity libroEntity = new LibroEntity();
        libroEntity.setIsbn(request.getIsbn());
        libroEntity.setAnioPublicacion(request.getAnioPublicacion());

        // .... //

        libroEntity.setAutorEntity(autorBd);
        libroEntity.setEditorialEntity(editorialBd);

        // aumentamos en uno el numero de libros del autor
        autorBd.setNumLibros(autorBd.getNumLibros() + 1);
        autorRepository.save(autorBd);

        libroRepository.save(libroEntity);

        // todo: Convertir libroEntity a libroResponse
    }
}
