package com.example.spring_2.service.impl;

import com.example.spring_2.dto.AutorCreateRequest;
import com.example.spring_2.dto.ReniecResponse;
import com.example.spring_2.entity.AutorEntity;
import com.example.spring_2.feignClient.ReniecClient;
import com.example.spring_2.repository.AutorRepository;
import com.example.spring_2.service.AutorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AutorServiceImpl implements AutorService {
    private AutorRepository autorRepository;
    private ReniecClient reniecClient;
    @Value("${reniec.token}")
    private String token;
    public AutorServiceImpl(AutorRepository autorRepository, ReniecClient reniecClient) {
        this.autorRepository = autorRepository;
        this.reniecClient = reniecClient;
    }
    @Override
    public AutorEntity createAutor(AutorCreateRequest autorRequest) {
        // verificamos el dni - formato valido (8 digitos)
        String dni = autorRequest.getDni();
        if (dni.length() != 8) {
            // todo: retornar error de formato
            return null;
        }
        // todo: consultar a la api de RENIEC la informacion
        ReniecResponse infoPersona = reniecClient.getPersonaInfo(autorRequest.getDni(), token);
        // ya tenemos la informacion de reniec

        AutorEntity autorEntity = new AutorEntity();
        autorEntity.setNombre(infoPersona.getFirstName());
        autorEntity.setApellidoPaterno(infoPersona.getFirstLastName());
        autorEntity.setApellidoMaterno(infoPersona.getSecondLastName());
        autorEntity.setCreatedAt(new Date());
        autorEntity.setNumLibros(0);
        autorEntity.setEstado(true);
        autorEntity.setNacionalidad(autorRequest.getNacionalidad());
        autorEntity.setDni(dni);
        autorRepository.save(autorEntity);
        return autorEntity;
    }

    @Override
    public List<AutorEntity> getAll() {
        return List.of();
    }

    @Override
    public AutorEntity findById(String dni) {
        return null;
    }

    @Override
    public AutorEntity updateById(String dni, AutorEntity autorEntity) {
        return null;
    }

    @Override
    public boolean deleteById(String dni) {
        return false;
    }
}
