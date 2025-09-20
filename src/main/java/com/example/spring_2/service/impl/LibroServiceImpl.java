package com.example.spring_2.service.impl;

import com.example.spring_2.dto.request.LibroCreateRequest;
import com.example.spring_2.dto.response.InfoAutorResponse;
import com.example.spring_2.dto.response.LibroResponse;
import com.example.spring_2.entity.AutorEntity;
import com.example.spring_2.entity.EditorialEntity;
import com.example.spring_2.entity.LibroEntity;
import com.example.spring_2.repository.AutorRepository;
import com.example.spring_2.repository.EditorialRepository;
import com.example.spring_2.repository.LibroRepository;
import com.example.spring_2.service.LibroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        libroEntity.setTitulo(request.getTitulo());
        libroEntity.setNumeroPaginas(request.getNumeroPaginas());
        libroEntity.setIdioma(request.getIdioma());
        libroEntity.setCategoria(request.getCategoria());
        libroEntity.setEdicion(request.getEdicion());
        libroEntity.setDescripcion(request.getDescripcion());
        libroEntity.setCreatedAt(new Date());
        libroEntity.setEstado(true);
        // .... //

        libroEntity.setAutorEntity(autorBd);
        libroEntity.setEditorialEntity(editorialBd);

        // aumentamos en uno el numero de libros del autor
        autorBd.setNumLibros(autorBd.getNumLibros() + 1);
        autorRepository.save(autorBd);

        libroRepository.save(libroEntity);

        // todo: Convertir libroEntity a libroResponse
        InfoAutorResponse infoAutorResponse = new InfoAutorResponse(
                autorBd.getNombre(),
                autorBd.getApellidoPaterno(),
                autorBd.getApellidoMaterno()
                );
        LibroResponse libroResponse = new LibroResponse();
        libroResponse.setIsbn(isbn);
        libroResponse.setTitulo(libroEntity.getTitulo());
        libroEntity.setNumeroPaginas(libroEntity.getNumeroPaginas());
        libroResponse.setAnioPublicacion(libroEntity.getAnioPublicacion());
        libroResponse.setIdioma(libroEntity.getIdioma());
        libroResponse.setCategoria(libroEntity.getCategoria());
        libroResponse.setEdicion(libroEntity.getEdicion());
        libroResponse.setDescripcion(libroEntity.getDescripcion());
        libroResponse.setInfoAutorResponse(infoAutorResponse);
        libroResponse.setEditorial(editorialBd.getNombre());
        return libroResponse;
    }

    @Override
    public List<LibroResponse> findLibros(Pageable pageable) {
        Page<LibroEntity> libroEntities = libroRepository.findAll(pageable);
        List<LibroResponse> libroResponses = new ArrayList<>();
        for(LibroEntity entity: libroEntities) {
            LibroResponse libroResponse = new LibroResponse();
            libroResponse.setIsbn(entity.getIsbn());
            libroResponse.setTitulo(entity.getTitulo());
            libroResponse.setAnioPublicacion(entity.getAnioPublicacion());
            libroResponse.setIdioma(entity.getIdioma());
            libroResponse.setCategoria(entity.getCategoria());
            libroResponse.setEdicion(entity.getDescripcion());
            libroResponse.setDescripcion(entity.getDescripcion());
            AutorEntity autorEntity = entity.getAutorEntity();
            InfoAutorResponse infoAutorResponse = new InfoAutorResponse(
                    autorEntity.getNombre(),
                    autorEntity.getApellidoPaterno(),
                    autorEntity.getApellidoMaterno()
            );
            libroResponse.setInfoAutorResponse(infoAutorResponse);
            libroResponse.setEditorial(entity.getEditorialEntity().getNombre());
            libroResponses.add(libroResponse);
        }
        return libroResponses;
    }
}
