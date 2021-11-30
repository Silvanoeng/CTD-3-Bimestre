package com.example.clinica_daniel.repository;

import com.example.clinica_daniel.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<DentistaEntity, Integer> {
}
