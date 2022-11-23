package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.models.dtos.Course;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseService {

    private List <Course> courses = new LinkedList<>();

    public List<Course> findAll(){
        return courses;
    }

    // public Course create(Course course){
    //     courses.add(course);
    //     return course;
    // }

    public Course create(Course course){
        log.info("Estudante:",course);
        boolean hasCourse = courses.stream().anyMatch((s)->{
            return s.getName().equals(course.getName());
        });
        if (hasCourse){
            throw new RuntimeException("Curso ja existe");
        }
        courses.add(course);
        return course;
    }

    // public Student findById(UUID id){
    public Course findById(Integer id){
        for (Course course: courses){
            // UUID courseId = course.getId();
            Integer courseId = course.getId();
            if (courseId.equals(id)){
                return course;
            }
        }
        throw new RuntimeException("Curso nao existe");
    }

    // public Student deleteById(UUID id){
    public Course deleteById(Integer id){
        for (Course course: courses){
            // UUID studentId = course.getId();
            Integer courseId = course.getId();
            if (courseId.equals(id)){
                courses.remove(course);
                return course;
            }
        }
        throw new RuntimeException("Curso deletado nao existe");
    }

    // public Student updateById(UUID id, Course courseUpdated){
    public Course updateById(Integer id, Course courseUpdated){
        for (Course course: courses){
            // UUID courseId = course.getId();
            Integer courseId = course.getId();
            if (courseId.equals(id)){
                courses.remove(course);
                create(courseUpdated);
                return courseUpdated;
            }
        }
        throw new RuntimeException("Curso atualizado nao existe");
    }



}


