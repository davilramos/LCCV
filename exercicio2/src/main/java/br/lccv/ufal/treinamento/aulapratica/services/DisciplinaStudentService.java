package br.lccv.ufal.treinamento.aulapratica.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.DisciplinaStudentBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaStudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;
import br.lccv.ufal.treinamento.aulapratica.domains.models.DisciplinaStudent;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;
import br.lccv.ufal.treinamento.aulapratica.repositories.DisciplinaRepository;
import br.lccv.ufal.treinamento.aulapratica.repositories.DisciplinaStudentRepository;
import br.lccv.ufal.treinamento.aulapratica.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class DisciplinaStudentService {

    private final DisciplinaStudentRepository repository;
    private final StudentRepository studentRepository;
    private final DisciplinaRepository disciplinaRepository;


    public DisciplinaStudent create(DisciplinaStudentInput disciplinaStudentInput){
        log.info("Cadastro:",disciplinaStudentInput);
        DisciplinaStudent disciplinaStudent = DisciplinaStudentBuilder.build(disciplinaStudentInput);

        System.out.println(disciplinaStudentInput);

        Disciplina disciplina = disciplinaRepository.getReferenceById(disciplinaStudentInput.getDisciplinaId());
        Student student = studentRepository.getReferenceById(disciplinaStudentInput.getStudentId());

        disciplinaStudent.setDisciplina(disciplina);
        disciplinaStudent.setStudent(student);

        disciplinaStudent = repository.save(disciplinaStudent);

        return disciplinaStudent;
    }

}
