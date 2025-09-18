package com.example.spring_2.service.impl;

import com.example.spring_2.dto.request.LoginRequest;
import com.example.spring_2.dto.request.UsuarioCreateRequest;
import com.example.spring_2.dto.response.UsuarioResponse;
import com.example.spring_2.entity.RoleEntity;
import com.example.spring_2.entity.UsuarioEntity;
import com.example.spring_2.repository.RoleRepository;
import com.example.spring_2.repository.UsuarioRepository;
import com.example.spring_2.service.JwtService;
import com.example.spring_2.service.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final RoleRepository roleRepository;
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetaisServiceImpl userDetaisService;

    public UsuarioServiceImpl(RoleRepository roleRepository, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, JwtService jwtService, UserDetaisServiceImpl userDetaisService) {
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetaisService = userDetaisService;
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
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsername(usuarioCreateRequest.getUsername());
        usuarioEntity.setPassword(new BCryptPasswordEncoder().encode(usuarioCreateRequest.getPassword()));
        RoleEntity roleEntity = roleEntityOptional.get();
        usuarioEntity.setRoleEntity(roleEntity);
        usuarioRepository.save(usuarioEntity);
        return new UsuarioResponse(usuarioEntity.getUserId(),usuarioEntity.getUsername(), role);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        if (auth.isAuthenticated()) {
            UserDetails user = userDetaisService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtService.generateToken(user);
            return token;
        }
        return null;
    }
}
