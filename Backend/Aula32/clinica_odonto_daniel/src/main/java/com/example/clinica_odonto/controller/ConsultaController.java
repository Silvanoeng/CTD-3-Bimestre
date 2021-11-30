package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Consulta consulta) {
        Consulta consultaSalvar = consultaService.salvar(consulta);

        if (consultaSalvar != null)
            return ResponseEntity.ok(consultaSalvar);

        return ResponseEntity.badRequest().body("Sua consulta não foi salva.");
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscarPorId(id);

        if(consulta != null)
            return ResponseEntity.ok(consulta);

        return ResponseEntity.badRequest().body("Consulta não encontrado.");
    }

    @GetMapping("/listar")
    public ResponseEntity listar() {
        Map<Integer, Consulta> buscarTodos = consultaService.buscarTodos();

        if (buscarTodos != null)
            return ResponseEntity.ok(buscarTodos);

        return ResponseEntity.badRequest().body("Não existe nenhuma consulta cadastrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        consultaService.deletar(id);
        return ResponseEntity.ok("Consulta deletada");
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody Consulta consulta) {
        Consulta consultaAlterada = consultaService.atualizar(id, consulta);

        if (consultaAlterada != null)
            return ResponseEntity.ok(consultaAlterada);

        return ResponseEntity.badRequest().body("Não foi editada nenhuma consulta.");
    }

}
