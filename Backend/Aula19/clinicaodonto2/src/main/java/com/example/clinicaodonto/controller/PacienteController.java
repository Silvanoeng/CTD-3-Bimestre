package com.example.clinicaodonto.controller;


import com.example.clinicaodonto.model.Paciente;
import com.example.clinicaodonto.service.ClinicaOdonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PacienteController {
    public final ClinicaOdonto<Paciente> pacienteService;

    @Autowired
    public PacienteController(ClinicaOdonto<Paciente> pacienteService){this.pacienteService = pacienteService;}

    @GetMapping("/searchPac/{id}")
    public String searchId(@PathVariable Integer id, Model resultado) {
        Paciente paciente = pacienteService.search(id);
        resultado.addAttribute("parametro", "Pac");
        resultado.addAttribute("nome", paciente.getNome());
        resultado.addAttribute("sobrenome", paciente.getSobrenome());
        resultado.addAttribute("email", paciente.getEmail());
        return "index";
    }


    @GetMapping("/searchAllPac")
    public String searchAll(Model buscaTodos) {
        List<Paciente> busca = pacienteService.searchAll();
        buscaTodos.addAttribute("parametro", "Pac");
        buscaTodos.addAttribute("listaTodos", busca);
        return "lista";
    }


    @GetMapping("/emailPac/{email}")
    public String searchEmail(@PathVariable String email, Model resultado) {
        Paciente paciente = pacienteService.searchEmail(email);
        resultado.addAttribute("parametro", "Pac");
        resultado.addAttribute("nome", paciente.getNome());
        resultado.addAttribute("sobrenome", paciente.getSobrenome());
        resultado.addAttribute("email", paciente.getEmail());
        return "index";
    }
}
