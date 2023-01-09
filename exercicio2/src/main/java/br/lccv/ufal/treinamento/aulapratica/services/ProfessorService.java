package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.ProfessorBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.ProfessorInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Professor;
import br.lccv.ufal.treinamento.aulapratica.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class ProfessorService {

    private final ProfessorRepository repository;


    public Professor create(ProfessorInput professorInput){
        log.info("Curso:",professorInput);
        Professor professor = ProfessorBuilder.build(professorInput);
        professor = repository.save(professor);
        return professor;
    }

    public List<Professor> findAll(){
        List<Professor> allProfessors = repository.findAll();
        return allProfessors;
    }

    public Professor findOne(UUID id){
        Professor professor = repository.getReferenceById(id);
        return professor;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public Professor update(UUID id, ProfessorInput input){
        Professor professor = repository.getReferenceById(id);
        professor.setName(input.getName());
        repository.save(professor);
        return professor;
    }

    public Disciplina findProfessorDisciplina(UUID id){
        Professor professor = repository.getReferenceById(id);
        return professor.getDisciplina();
    }


}


