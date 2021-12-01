package com.example.clinica_daniel.controller;

import com.example.clinica_daniel.dto.EnderecoDTO;
import com.example.clinica_daniel.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @ExceptionHandler
    @ResponseBody
    public String dummyExceptionHandler(Exception e) {
        return e.getMessage();
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody EnderecoDTO endereco) {
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        EnderecoDTO enderecoDTO = enderecoService.buscarPorId(id);

        if(enderecoDTO != null)
            return ResponseEntity.ok(enderecoDTO);

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }

    @GetMapping("/listar")
    public ResponseEntity listar() {
        List<EnderecoDTO> buscarTodos = enderecoService.buscarTodos();

        if (buscarTodos != null)
            return ResponseEntity.ok(buscarTodos);

        return ResponseEntity.badRequest().body("Não existe nenhum paciente cadastrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        enderecoService.deletar(id);
        return ResponseEntity.ok("Paciente deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody EnderecoDTO endereco) {
        EnderecoDTO enderecoAlterado = enderecoService.atualizar(id, endereco);

        if (enderecoAlterado != null)
            return ResponseEntity.ok(enderecoAlterado);

        return ResponseEntity.badRequest().body("Não foi editado nenhum paciente.");
    }
}
