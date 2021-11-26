package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/listar")
    public ResponseEntity listar() {
        Map<Integer, Paciente> buscarTodos = pacienteService.buscarTodos();

        if (buscarTodos != null)
            return ResponseEntity.ok(buscarTodos);

        return ResponseEntity.badRequest().body("Não existe nenhum paciente cadastrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return ResponseEntity.ok("Paciente deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody Paciente paciente) {
        Paciente pacienteAlterada = pacienteService.atualizar(id, paciente);

        if (pacienteAlterada != null)
            return ResponseEntity.ok(pacienteAlterada);

        return ResponseEntity.badRequest().body("Não foi editado nenhum paciente.");
    }
}
