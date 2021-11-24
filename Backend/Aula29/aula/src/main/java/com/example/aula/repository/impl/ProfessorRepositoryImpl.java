package com.example.aula.repository.impl;

import com.example.aula.entities.ProfessorEntity;
import com.example.aula.repository.ProfessorRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public abstract class ProfessorRepositoryImpl implements ProfessorRepository {

    @Query("select p from professores p where p.nome = ?1 and p.curso = ?3")
    abstract Optional<ProfessorEntity> buscarPorNome(String nomeProf, String curso, String q);

    @Query("select p.nome from professores p where p.id = ?1")
    abstract Optional<ProfessorEntity> buscarIdRetornoNome(Integer id);

}
