package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.domains.builder.StudentBuilder;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.StudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Course;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;
import br.lccv.ufal.treinamento.aulapratica.repositories.CourseRepository;
import br.lccv.ufal.treinamento.aulapratica.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    
    public Student create(StudentInput studentInput){
        log.info("Estudante:",studentInput);        
        Student student = StudentBuilder.build(studentInput);
        Course course = courseRepository.getReferenceById(studentInput.getCourseId());
        student.setCourse(course);

        student = studentRepository.save(student);
        return student;
    }

    public List<Student> findAll(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents ;
    }

    public Student findOne(UUID id){
        Student student = studentRepository.getReferenceById(id);
        return student;
    }

    public void delete(UUID id){
        studentRepository.deleteById(id);
    }

    public Student update(UUID id, StudentInput input){

        Student student = studentRepository.getReferenceById(id);

        student.setAge(input.getAge());
        student.setCpf(input.getCpf());
        student.setName(input.getName());
        studentRepository.save(student);
        return student;
    }

    public Course findStudentCourse(UUID id){

        Student student = studentRepository.getReferenceById(id);
        Course course = student.getCourse();
        return course;

    }

}
