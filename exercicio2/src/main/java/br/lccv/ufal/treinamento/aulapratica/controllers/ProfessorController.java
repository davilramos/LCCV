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
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.ProfessorInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Professor;
import br.lccv.ufal.treinamento.aulapratica.services.ProfessorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Professor", description = "Endpoint professores")
@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor //(onConstructor = @__(@Autowired))
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping("/")
    public ProfessorDTO create(@Valid @RequestBody ProfessorInput professorInput){
        Professor professor = service.create(professorInput);
        return ProfessorBuilder.build(professor);
    }

    @GetMapping
    public List<ProfessorDTO> findAll(){
        List<Professor> allProfessors = service.findAll();
        return ProfessorBuilder.build(allProfessors);
    }

    @GetMapping("/{id}")
    public ProfessorDTO findOne(@PathVariable UUID id){
        Professor professor = service.findOne(id);
        return ProfessorBuilder.build(professor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ProfessorDTO update(@PathVariable UUID id, @Valid @RequestBody ProfessorInput professorInput){
        Professor professor = service.update(id, professorInput);
        return ProfessorBuilder.build(professor);
    }

    @GetMapping("{id}/disciplina")
    public DisciplinaDTO findProfessorDisciplina(@PathVariable UUID id){
        Disciplina disciplina = service.findProfessorDisciplina(id);
        return DisciplinaBuilder.build(disciplina);
    }


}
