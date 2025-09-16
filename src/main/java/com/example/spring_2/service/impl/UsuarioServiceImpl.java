package com.example.spring_2.service.impl;

import com.example.spring_2.dto.request.UsuarioCreateRequest;
import com.example.spring_2.dto.response.UsuarioResponse;
import com.example.spring_2.entity.RoleEntity;
import com.example.spring_2.entity.UsuarioEntity;
import com.example.spring_2.repository.RoleRepository;
import com.example.spring_2.repository.UsuarioRepository;
import com.example.spring_2.service.UsuarioService;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {
    private final RoleRepository roleRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(RoleRepository roleRepository, UsuarioRepository usuarioRepository) {
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioResponse createUser(UsuarioCreateRequest usuarioCreateRequest) {
        // verificar que el rol exista en la base de datos
        // verificar que el username no sea duplicado
        String role = usuarioCreateRequest.getRole();
        String username = usuarioCreateRequest.getUsername();
        Optional<RoleEntity> roleEntityOptional = roleRepository.findByRole(role);
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findByUsername(username);

        if (roleEntityOptional.isEmpty() || usuarioEntityOptional.isPresent()) {
            return null;
        }
        return null;
    }
}
