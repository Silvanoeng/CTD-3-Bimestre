package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id);

        if(paciente != null)
            return ResponseEntity.ok(pacienteService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Paciente.java não encontrado");
    }
}