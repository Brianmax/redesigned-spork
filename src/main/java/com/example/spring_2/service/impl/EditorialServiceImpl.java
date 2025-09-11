package com.example.spring_2.service.impl;

import com.example.spring_2.dto.request.EditorialCreateRequest;
import com.example.spring_2.dto.response.EditorialResponse;
import com.example.spring_2.dto.response.SunatResponse;
import com.example.spring_2.entity.EditorialEntity;
import com.example.spring_2.feignClient.SunatClient;
import com.example.spring_2.repository.EditorialRepository;
import com.example.spring_2.service.EditorialService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EditorialServiceImpl implements EditorialService {
    private final EditorialRepository editorialRepository;
    private final SunatClient sunatClient;
    @Value("${api.token}")
    private String token;

    public EditorialServiceImpl(EditorialRepository editorialRepository, SunatClient sunatClient) {
        this.editorialRepository = editorialRepository;
        this.sunatClient = sunatClient;
    }

    @Override
    public EditorialResponse createEditorial(EditorialCreateRequest request) {
        // verificar si ya existe el ruc
        String ruc = request.getRuc();

        if (editorialRepository.existsById(ruc)) {
            // todo: responder con un error de ruc duplicado
            return null;
        }

        SunatResponse response = sunatClient.getInfoEmpresa(ruc, token);

        EditorialEntity editorialEntity = new EditorialEntity();

        editorialEntity.setNombre(response.getRazonSocial());
        editorialEntity.setDepartamento(response.getDepartamento());
        editorialEntity.setDireccion(response.getDireccion());
        editorialEntity.setSede(response.getDistrito());
        editorialEntity.setTipo(response.getTipo());
        editorialEntity.setNumeroTrabajadores(response.getNumeroTrabajadores());

        // campos por defecto

        editorialEntity.setCreatedAt(new Date());
        editorialEntity.setEstado(true);
        editorialEntity.setPais("PERU");
        editorialEntity.setRuc(ruc);

        // guardamos la entidad en base de datos

        editorialRepository.save(editorialEntity);

        return new EditorialResponse(
                ruc,
                editorialEntity.getNombre(),
                editorialEntity.getFechaFundacion(),
                editorialEntity.getPais(),
                editorialEntity.getDepartamento(),
                editorialEntity.getTipo(),
                editorialEntity.getNumeroTrabajadores(),
                editorialEntity.getDireccion(),
                editorialEntity.getSede()
        );
    }
}
