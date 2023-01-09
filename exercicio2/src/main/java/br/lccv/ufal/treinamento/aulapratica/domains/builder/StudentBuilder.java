package br.lccv.ufal.treinamento.aulapratica.domains.builder;

import java.util.LinkedList;
import java.util.List;

import br.lccv.ufal.treinamento.aulapratica.domains.dto.StudentDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.StudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Student;

public class StudentBuilder {

    public static Student build (StudentInput input){
        return Student.builder()
        .age(input.getAge())
        .cpf(input.getCpf())
        .name(input.getName()).build();

    }

    public static StudentDTO build (Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .age(student.getAge())
                .cpf(student.getCpf())
                .name(student.getName())
                .build();
    }

    public static List<StudentDTO> build (List<Student> students){
        
        List<StudentDTO> finalList = new LinkedList<>();
        for (Student student : students){
            StudentDTO studentDTO = build(student);
            finalList.add(studentDTO);
        }

        return finalList;
    }
    
}
