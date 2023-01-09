package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.DisciplinaBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Professor;
import br.lccv.ufal.treinamento.aulapratica.repositories.DisciplinaRepository;
import br.lccv.ufal.treinamento.aulapratica.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public Disciplina create(DisciplinaInput disciplinaInput){
        log.info("Disciplina:",disciplinaInput);
        Disciplina disciplina = DisciplinaBuilder.build(disciplinaInput);
        Professor professor = professorRepository.getReferenceById(disciplinaInput.getProfessorId());
        disciplina.setProfessor(professor);
        disciplina = disciplinaRepository.save(disciplina);
        return disciplina;
    }

    public List<Disciplina> findAll(){
        List<Disciplina> allDisciplinas = disciplinaRepository.findAll();
        return allDisciplinas;
    }

    public Disciplina findOne(UUID id){
        Disciplina disciplina = disciplinaRepository.getReferenceById(id);
        return disciplina;
    }

    public void delete(UUID id){
        disciplinaRepository.deleteById(id);
    }

    public Disciplina update(UUID id, DisciplinaInput input){
        Disciplina disciplina = disciplinaRepository.getReferenceById(id);
        disciplina.setName(input.getName());
        disciplinaRepository.save(disciplina);
        return disciplina;
    }

    public Professor findProfessorDisciplina(UUID id){
        Disciplina disciplina = disciplinaRepository.getReferenceById(id);
        return disciplina.getProfessor();
    }



}


