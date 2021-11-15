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

    @GetMapping("/idPaciente")
    public String searchId(Model resultado) {
        Paciente paciente = pacienteService.search(1);
        resultado.addAttribute("parametro", "Pac");
        resultado.addAttribute("nome", paciente.getNome());
        resultado.addAttribute("sobrenome", paciente.getSobrenome());
        resultado.addAttribute("email", paciente.getEmail());
        return "index";
    }

//    @GetMapping("/searchAllPac")
//    public List<Paciente> searchAll() {
//        return pacienteService.searchAll();
//    }

    @GetMapping("/emailPaciente")
    public String searchEmail(Model resultado) {
        Paciente paciente = pacienteService.searchEmail("paulaaraujo@email.com");
        resultado.addAttribute("parametro", "Pac");
        resultado.addAttribute("nome", "Paula");
        resultado.addAttribute("sobrenome", "Araujo");
        resultado.addAttribute("email", "paulaaraujo@email.com");
        return "index";
    }
}
