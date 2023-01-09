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

import br.lccv.ufal.treinamento.aulapratica.domains.builder.CourseBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.builder.StudentBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.CourseDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.StudentDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.CourseInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Course;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;
import br.lccv.ufal.treinamento.aulapratica.services.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Courses", description = "Endpoint courses")
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor //(onConstructor = @__(@Autowired))
public class CourseController {

    private final CourseService service;

    @PostMapping("/")
    public CourseDTO create(@Valid @RequestBody CourseInput courseInput){
        Course course = service.create(courseInput);
        return CourseBuilder.build(course);
    }

    @GetMapping
    public List<CourseDTO> findAll(){
        List<Course> allCourses = service.findAll();
        return CourseBuilder.build(allCourses);
    }

    @GetMapping("/{id}")
    public CourseDTO findOne(@PathVariable UUID id){
        Course course = service.findOne(id);
        return CourseBuilder.build(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable UUID id, @Valid @RequestBody CourseInput courseInput){
        Course course = service.update(id, courseInput);
        return CourseBuilder.build(course);
    }

    @GetMapping("{id}/students")
    public List<StudentDTO> findAllStudents(@PathVariable UUID id){
        List<Student> students = service.findAllStudents(id);
        return StudentBuilder.build(students);

    }


}
