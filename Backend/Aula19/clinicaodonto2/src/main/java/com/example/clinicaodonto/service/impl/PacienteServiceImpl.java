package com.example.clinicaodonto.service.impl;

import com.example.clinicaodonto.model.Endereco;
import com.example.clinicaodonto.model.Paciente;
import com.example.clinicaodonto.service.ClinicaOdonto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteServiceImpl implements ClinicaOdonto<Paciente> {
    private Endereco end1 = new Endereco(1, "Rua 11 de Abril", "987", "Mostardas", "RS");
    private Endereco end2 = new Endereco(2, "Rua Manoel Velho", "850", "Mostardas", "RS");
    private Paciente pac1 = new Paciente(1, "Marcos", "Silva", "marcossilva@email.com", "987654321", LocalDate.now(), end1);
    private Paciente pac2 = new Paciente(2, "Paula", "Araujo", "paulaaraujo@email.com", "123456789", LocalDate.now(), end2);


    @Override
    public Paciente search(Integer id) {
        List<Paciente> search = Arrays.asList(pac1,pac2);
        for (Paciente paciente: search) {
            if (paciente.getId().equals(id)){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public List<Paciente> searchAll() {
        return Arrays.asList(pac1,pac2);
    }

    @Override
    public Paciente searchEmail(String word) {
        List<Paciente> search = Arrays.asList(pac1,pac2);
        for (Paciente paciente: search) {
            if (paciente.getEmail().equals(word)){
                return paciente;
            }
        }
        return null;
    }
}
