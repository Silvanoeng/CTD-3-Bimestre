package com.example.clinica_odonto.controller;

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
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscar(id));
    }

//    @GetMapping("criar")
//    public Paciente criarPaciente() {
//        return pacienteService.criarPaciente();
//    }
//
    @GetMapping("/listar")
    public Map<Integer, Paciente> listarPacientes() {
        return pacienteService.buscarTodos();
    }
//
//    @GetMapping("buscar/{id}")
//    public String buscarPaciente(@PathVariable Integer id) {
//        pacienteService.buscarPaciente(id);
//        return "Paciente: " + pacienteService.buscarPaciente(id).getNome();
//    }
//
//    @GetMapping("deletar/{id}")
//    public String deletarPacientes(@PathVariable Integer id) {
//        String nomePaciente = pacienteService.buscarPaciente(id).getNome();
//        pacienteService.deletar(id);
//        return "Paciente " + nomePaciente + " foi deletado.";
//    }
//
//    @GetMapping("editar/{id}/{nome}")
//    public String editarPaciente(@PathVariable Integer id, @PathVariable String nome){
//        pacienteService.atualizarPaciente(id,nome);
//        return "Paciente " + pacienteService.buscarPaciente(id).getNome() + " esta atualizado..";
//    }
}
