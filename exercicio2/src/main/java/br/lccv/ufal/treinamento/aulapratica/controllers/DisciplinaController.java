package br.lccv.ufal.treinamento.aulapratica.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.DisciplinaBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.builder.ProfessorBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.DisciplinaDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.ProfessorDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Professor;
import br.lccv.ufal.treinamento.aulapratica.services.DisciplinaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Disciplinas", description = "Endpoint disciplinas")
@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor //(onConstructor = @__(@Autowired))
public class DisciplinaController {

    private final DisciplinaService service;

    @PostMapping("/")
    public DisciplinaDTO create(@Valid @RequestBody DisciplinaInput disciplinaInput){
        Disciplina disciplina = service.create(disciplinaInput);
        return DisciplinaBuilder.build(disciplina);
    }

    @GetMapping
    public List<DisciplinaDTO> findAll(){
        List<Disciplina> allDisciplinas = service.findAll();
        return DisciplinaBuilder.build(allDisciplinas);
    }

    @GetMapping("/{id}")
    public DisciplinaDTO findOne(@PathVariable UUID id){
        Disciplina disciplina = service.findOne(id);
        return DisciplinaBuilder.build(disciplina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public DisciplinaDTO update(@PathVariable UUID id, @Valid @RequestBody DisciplinaInput disciplinaInput){
        Disciplina disciplina = service.update(id, disciplinaInput);
        return DisciplinaBuilder.build(disciplina);
    }

    @GetMapping("{id}/professor")
    public ProfessorDTO findDisciplinaProfessor(@PathVariable UUID id){
        Professor professor = service.findProfessorDisciplina(id);
        return ProfessorBuilder.build(professor);
    }

}
