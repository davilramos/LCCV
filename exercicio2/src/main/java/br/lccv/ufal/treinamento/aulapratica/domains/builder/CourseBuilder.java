package br.lccv.ufal.treinamento.aulapratica.domains.builder;

import java.util.LinkedList;
import java.util.List;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.CourseDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.CourseInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Course;

public class CourseBuilder {
    public static Course build (CourseInput input){
        return Course.builder()
        .name(input.getName())
        .build();
    }

    public static CourseDTO build (Course course){
        return CourseDTO.builder()
                .name(course.getName())
                .id(course.getId())
                .build();
    }

    public static List<CourseDTO> build (List<Course> courses){
        
        List<CourseDTO> finalList = new LinkedList<>();
        for (Course course : courses){
            CourseDTO courseDTO = build(course);
            finalList.add(courseDTO);
        }

        return finalList;
    }
}
