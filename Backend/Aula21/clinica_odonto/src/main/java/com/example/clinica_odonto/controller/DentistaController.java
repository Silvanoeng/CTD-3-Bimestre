package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<Dentista> salvar(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscarPorId(id);

        if(dentista != null)
            return ResponseEntity.ok(dentistaService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Dentista não encontrado");
    }

    @GetMapping("/listar")
    public ResponseEntity listar() {
        Map<Integer, Dentista> buscarTodos = dentistaService.buscarTodos();

        if (buscarTodos != null)
            return ResponseEntity.ok(buscarTodos);

        return ResponseEntity.badRequest().body("Não existe nenhum dentista cadastrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        dentistaService.deletar(id);
        return ResponseEntity.ok("Dentista deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody Dentista dentista) {
        Dentista dentistaAlterada = dentistaService.atualizar(id, dentista);

        if (dentistaAlterada != null)
            return ResponseEntity.ok(dentistaAlterada);

        return ResponseEntity.badRequest().body("Não foi editado nenhum dentista.");
    }

}
