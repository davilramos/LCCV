package br.lccv.ufal.treinamento.aulapratica.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lccv.ufal.treinamento.aulapratica.models.dtos.Course;
import br.lccv.ufal.treinamento.aulapratica.services.CourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor//(onConstructor = @__(@Autowired))
public class CourseController {

    private final CourseService service;

    @PostMapping("/")
    public Course create(@Valid Course course){ //problema com @requestbody
        return service.create(course);
    }

    @GetMapping
    public List<Course> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    // public Course findById(@PathVariable UUID id){
    public Course findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    // public Course findById(@PathVariable UUID id){
    public Course deleteById(@PathVariable Integer id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Course updateById(@PathVariable Integer id, @Valid Course course){
        return service.updateById(id, course);
    }


}
