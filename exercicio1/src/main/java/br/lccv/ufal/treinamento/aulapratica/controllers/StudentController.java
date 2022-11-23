package br.lccv.ufal.treinamento.aulapratica.controllers;

import java.util.List;
// import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lccv.ufal.treinamento.aulapratica.models.dtos.Student;
import br.lccv.ufal.treinamento.aulapratica.services.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService service;

    @PostMapping("/")
    public Student create(@Valid Student student){ //problema com @requestbody
        return service.create(student);
    }

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    // public Student findById(@PathVariable UUID id){
    public Student findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    // public Student findById(@PathVariable UUID id){
    public Student deleteById(@PathVariable Integer id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student updateById(@PathVariable Integer id, @Valid Student student){
        return service.updateById(id, student);
    }


}
