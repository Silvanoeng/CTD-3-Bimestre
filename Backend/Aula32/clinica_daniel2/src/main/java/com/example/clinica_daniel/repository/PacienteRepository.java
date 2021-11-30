package com.example.clinica_daniel.repository;

import com.example.clinica_daniel.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
}
