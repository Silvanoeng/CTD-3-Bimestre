package com.example.clinica_daniel.controller;

import com.example.clinica_daniel.dto.DentistaDTO;
import com.example.clinica_daniel.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

//    @ExceptionHandler
//    @ResponseBody
//    public String dummyExceptionHandler(Exception e) {
//        return e.getMessage();
//    }

    @PostMapping
    public ResponseEntity<DentistaDTO> salvar(@RequestBody DentistaDTO dentistaDTO) {
        return ResponseEntity.ok(dentistaService.salvar(dentistaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Integer id) {

        DentistaDTO dentista = dentistaService.buscarPorId(id);

        if (dentista != null) {
            return ResponseEntity.ok(dentista);
        }

        return ResponseEntity.badRequest().body("Dentista não encontrado");
    }

    @GetMapping("/listar")
    public ResponseEntity listar() {
        List<DentistaDTO> buscarTodos = dentistaService.buscarTodos();

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
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody DentistaDTO dentista) {
        DentistaDTO dentistaAlterada = dentistaService.atualizar(id, dentista);

        if (dentistaAlterada != null)
            return ResponseEntity.ok(dentistaAlterada);

        return ResponseEntity.badRequest().body("Não foi editado nenhum dentista.");
    }
}
