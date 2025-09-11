package com.example.spring_2.repository;

import com.example.spring_2.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroEntity, String>{
}
