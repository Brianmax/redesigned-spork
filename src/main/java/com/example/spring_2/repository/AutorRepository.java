package com.example.spring_2.repository;

import com.example.spring_2.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorEntity, String> {
}
