package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Service
public class pacienteServiceImpl implements PacienteService {
    private static Map<Integer, Paciente> pacienteMap =new HashMap<>();
    private static String[] nomes = {"Lucas", "Ana", "Pedro", "Julia", "Roberto",
            "Larissa", "Antonio", "Pietra", "Rubens", "Giovana"};

    private static String[] sobrenomes = {"Silva", "Santos", "Gomes", "Paglia", "Grisa",
            "Andrade", "Quinteiros", "Tempesta", "Franco", "Andrade"};

    private static int idClasse=1;

    @Override
    public Paciente criarPaciente() {
        Random random = new Random();
        int numRand = 10;
        String nome = nomes[random.nextInt(numRand)];
        String sobrenome = sobrenomes[random.nextInt(numRand)];
        String email = nome.toLowerCase(Locale.ROOT) + sobrenome.toLowerCase(Locale.ROOT) +"@email.com";
        Integer id = idClasse++;
        pacienteMap.put(id, new Paciente(nome, sobrenome, email, (random.nextInt(numRand)+18)));
        return pacienteMap.get(id);
    }

    @Override
    public Map<Integer, Paciente> buscarPacientes() {
        return pacienteMap;
    }

    @Override
    public Paciente buscarPaciente(Integer id) {
        return pacienteMap.get(id);
    }

    @Override
    public Paciente atualizarPaciente(Integer id, String nome) {
        buscarPaciente(id).setNome(nome);
        return buscarPaciente(id);
    }

    @Override
    public void deletar(Integer id) {
        pacienteMap.remove(id);

    }
}
