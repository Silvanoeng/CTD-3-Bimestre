package com.example.clinicaodonto.controller;

import com.example.clinicaodonto.model.Dentista;
import com.example.clinicaodonto.service.ClinicaOdonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class DentistaController {
    private final ClinicaOdonto<Dentista> dentistaService;

    @Autowired
    public DentistaController(ClinicaOdonto<Dentista> dentistaService) {this.dentistaService = dentistaService;}

    @GetMapping("/searchDent/{id}")
    public String searchId(@PathVariable Integer id, Model resultado) {
        Dentista dentista = dentistaService.search(id);
        resultado.addAttribute("parametro", "Dent");
        resultado.addAttribute("nome", dentista.getNome());
        resultado.addAttribute("sobrenome", dentista.getSobrenome());
        resultado.addAttribute("NumMat", dentista.getNumMatricula());
        return "index";
    }


    @GetMapping("/searchAllDent")
    public String searchAll(Model buscaTodos) {
        List<Dentista> busca = dentistaService.searchAll();
        buscaTodos.addAttribute("parametro", "Dent");
        buscaTodos.addAttribute("listaTodos", busca);
        return "lista";
    }
}
