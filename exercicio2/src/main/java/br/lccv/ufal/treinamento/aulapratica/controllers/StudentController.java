package br.lccv.ufal.treinamento.aulapratica.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.CourseBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.builder.StudentBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.CourseDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.StudentDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.StudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Course;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;
import br.lccv.ufal.treinamento.aulapratica.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Students", description = "Endpoint students")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService service;

    @Operation(summary = "Criar novo estudante", description = "Criar novo estudante baseado no corpo da requisicao")
    @PostMapping("/")
    public StudentDTO create(@Valid @RequestBody StudentInput studentInput){ //problema com @requestbody
        Student student = service.create(studentInput);
        return StudentBuilder.build(student);
    }

    @GetMapping
    public List<StudentDTO> findAll(){
        List<Student> allStudents = service.findAll();
        return StudentBuilder.build(allStudents);
    }


    @GetMapping("/{id}")
    public StudentDTO findOne(@PathVariable UUID id){
        Student student = service.findOne(id);
        return StudentBuilder.build(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);

    }

    @PutMapping("/{id}")
    public StudentDTO updateOne(@PathVariable UUID id, @Valid @RequestBody StudentInput studentInput){
        Student student = service.update(id, studentInput);
        return StudentBuilder.build(student);
    }

    @GetMapping("/{id}/course")
    public CourseDTO findStudentCourse(@PathVariable UUID id){
        Course course = service.findStudentCourse(id);
        return CourseBuilder.build(course);
    }


}
