package com.example.clinica_daniel.controller;

import com.example.clinica_daniel.dto.EnderecoDTO;
import com.example.clinica_daniel.dto.PacEndDTO;
import com.example.clinica_daniel.dto.PacienteDTO;
import com.example.clinica_daniel.service.impl.EnderecoServiceImpl;
import com.example.clinica_daniel.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private EnderecoServiceImpl enderecoService;

//    PacienteDTO paciente, @RequestBody EnderecoDTO endereco

    @PostMapping
    public ResponseEntity<PacienteDTO> salvarPaciente(@RequestBody PacEndDTO pacEndDTO) {
        EnderecoDTO enderecoDTO = pacEndDTO.getEnderecoDTO();
        pacEndDTO.setEnderecoDTO(enderecoService.salvar(enderecoDTO));
        PacienteDTO pacienteDTO = new PacienteDTO(pacEndDTO);
        return ResponseEntity.ok(pacienteService.salvar(pacienteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        PacienteDTO paciente = pacienteService.buscarPorId(id);

        if(paciente != null)
            return ResponseEntity.ok(paciente);

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }

    @GetMapping("/listar")
    public ResponseEntity listar() {
        List<PacienteDTO> buscarTodos = pacienteService.buscarTodos();

        if (buscarTodos != null)
            return ResponseEntity.ok(buscarTodos);

        return ResponseEntity.badRequest().body("Não existe nenhum paciente cadastrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return ResponseEntity.ok("Paciente deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody PacienteDTO paciente, @RequestBody EnderecoDTO endereco) {

        PacienteDTO pacienteAlterado = pacienteService.atualizar(id, paciente);
        EnderecoDTO enderecoAlterado = enderecoService.atualizar(pacienteAlterado.getIdEndereco(), endereco);

        if (pacienteAlterado != null)
            return ResponseEntity.ok(pacienteAlterado);

        return ResponseEntity.badRequest().body("Não foi editado nenhum paciente.");
    }
}
