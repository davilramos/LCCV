package br.lccv.ufal.treinamento.aulapratica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository <Disciplina, UUID>{
    
}

