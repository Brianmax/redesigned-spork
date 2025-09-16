package com.example.spring_2.service.impl;

import com.example.spring_2.entity.UsuarioEntity;
import com.example.spring_2.repository.UsuarioRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetaisServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UserDetaisServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByUsername(username);
        if(optionalUsuarioEntity.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();
        SimpleGrantedAuthority roleUsuario = new SimpleGrantedAuthority(usuarioEntity.getRoleEntity().getRole());
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(roleUsuario);

        return new User(usuarioEntity.getUsername(), usuarioEntity.getPassword(), roles);
    }
}
