package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.CourseBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.CourseInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Course;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;
import br.lccv.ufal.treinamento.aulapratica.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class CourseService {

    private final CourseRepository repository;


    public Course create(CourseInput courseInput){
        log.info("Curso:",courseInput);
        Course course = CourseBuilder.build(courseInput);
        course = repository.save(course);
        return course;
    }

    public List<Course> findAll(){
        List<Course> allCourses = repository.findAll();
        return allCourses;
    }

    public Course findOne(UUID id){
        Course course = repository.getReferenceById(id);
        return course;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public Course update(UUID id, CourseInput input){
        Course course = repository.getReferenceById(id);
        course.setName(input.getName());
        repository.save(course);
        return course;
    }

    public List<Student> findAllStudents(UUID id){
        Course course = repository.getReferenceById(id);
        return course.getStudents();

    }

}


