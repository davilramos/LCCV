package br.lccv.ufal.treinamento.aulapratica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, UUID> {
    
}
