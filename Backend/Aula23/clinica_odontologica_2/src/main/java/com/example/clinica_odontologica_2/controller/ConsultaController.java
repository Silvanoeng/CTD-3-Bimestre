package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity<Consulta> salvarconsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.salvar(consulta));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscarPorId(id);

        if(consulta != null)
            return ResponseEntity.ok(consultaService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Consulta não encontrado");
    }
}
