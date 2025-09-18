package com.example.spring_2.config;

import com.example.spring_2.entity.RoleEntity;
import com.example.spring_2.entity.UsuarioEntity;
import com.example.spring_2.repository.RoleRepository;
import com.example.spring_2.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InitialConfig {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    public InitialConfig(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            RoleEntity roleEntity = roleRepository.findByRole("ADMIN").orElse(null);
            if(usuarioRepository.existsByUsername("george123")) {
                return;
            }
            usuarioEntity.setUsername("george123");
            usuarioEntity.setPassword(new BCryptPasswordEncoder().encode("12345"));
            usuarioEntity.setRoleEntity(roleEntity);
            usuarioRepository.save(usuarioEntity);
        };
    }
}
