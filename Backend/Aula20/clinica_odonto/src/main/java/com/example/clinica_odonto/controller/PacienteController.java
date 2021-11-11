package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("criar")
    public Paciente criarPaciente() {
        return pacienteService.criarPaciente();
    }

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes() {
        return pacienteService.buscarPacientes();
    }

    @GetMapping("buscar/{id}")
    public String buscarPaciente(@PathVariable Integer id) {
        pacienteService.buscarPaciente(id);
        return "Paciente: " + pacienteService.buscarPaciente(id).getNome();
    }

    @GetMapping("deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id) {
        String nomePaciente = pacienteService.buscarPaciente(id).getNome();
        pacienteService.deletar(id);
        return "Paciente " + nomePaciente + " foi deletado.";
    }

    @GetMapping("editar/{id}/{nome}")
    public String editarPaciente(@PathVariable Integer id, @PathVariable String nome){
        pacienteService.atualizarPaciente(id,nome);
        return "Paciente " + pacienteService.buscarPaciente(id).getNome() + " esta atualizado..";
    }
}
