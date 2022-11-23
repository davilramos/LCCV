package br.lccv.ufal.treinamento.aulapratica.services;

import java.util.LinkedList;
import java.util.List;
// import java.util.UUID;

import org.springframework.stereotype.Service;

import br.lccv.ufal.treinamento.aulapratica.models.dtos.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {
    
    private List <Student> students = new LinkedList<>();

    public Student create(Student student){
        log.info("Estudante:",student);
        boolean hasStudent = students.stream().anyMatch((s)->{
            return s.getCpf().equals(student.getCpf());
        });
        if (hasStudent){
            throw new RuntimeException("Estudante ja existe");
        }
        students.add(student);
        return student;
    }

    public List<Student> findAll(){
        return students;
    }

    // public Student findById(UUID id){
    public Student findById(Integer id){
        for (Student student: students){
            // UUID studentId = student.getId();
            Integer studentId = student.getId();
            if (studentId.equals(id)){
                return student;
            }
        }
        throw new RuntimeException("Estudante nao existe");
    }

    // public Student deleteById(UUID id){
    public Student deleteById(Integer id){
        for (Student student: students){
            // UUID studentId = student.getId();
            Integer studentId = student.getId();
            if (studentId.equals(id)){
                students.remove(student);
                return student;
            }
        }
        throw new RuntimeException("Estudante deletado nao existe");
    }

    // public Student updateById(UUID id, Student StudentUpdated){
    public Student updateById(Integer id, Student studentUpdated){
        for (Student student: students){
            // UUID studentId = student.getId();
            Integer studentId = student.getId();
            if (studentId.equals(id)){
                students.remove(student);
                create(studentUpdated);
                return studentUpdated;
            }
        }
        throw new RuntimeException("Estudante atualizado nao existe");
    }

}
