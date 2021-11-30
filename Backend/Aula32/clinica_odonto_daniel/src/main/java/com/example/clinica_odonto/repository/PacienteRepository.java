package com.example.clinica_odonto.repository;

import com.example.clinica_odonto.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
