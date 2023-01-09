package br.lccv.ufal.treinamento.aulapratica.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.DisciplinaStudentBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.DisciplinaStudentDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaStudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.DisciplinaStudent;
import br.lccv.ufal.treinamento.aulapratica.services.DisciplinaStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "DisciplinaStudents", description = "Cadastro de disciplina-estudante")
@RestController
@RequestMapping("/studentCadastro")
@RequiredArgsConstructor //(onConstructor = @__(@Autowired))
public class DisciplinaStudentController {

    private final DisciplinaStudentService service;


    @Operation(summary = "Cadastro de disciplina", description = "Criar um novo cadastro de disciplina")
    @PostMapping("/")
    public DisciplinaStudentDTO create(@Valid @Parameter @RequestBody DisciplinaStudentInput disciplinaStudentInput){

        System.out.println(disciplinaStudentInput);

        DisciplinaStudent disciplinaStudent = service.create(disciplinaStudentInput);
        return DisciplinaStudentBuilder.build(disciplinaStudent);
    }
    
}
