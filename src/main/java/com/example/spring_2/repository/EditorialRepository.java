package com.example.spring_2.repository;

import com.example.spring_2.entity.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<EditorialEntity, String> {
}
