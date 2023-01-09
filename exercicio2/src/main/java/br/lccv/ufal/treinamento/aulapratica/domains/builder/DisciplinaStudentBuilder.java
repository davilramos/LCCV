package br.lccv.ufal.treinamento.aulapratica.domains.builder;

import br.lccv.ufal.treinamento.aulapratica.domains.dto.DisciplinaStudentDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaStudentInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.DisciplinaStudent;

public class DisciplinaStudentBuilder {

    public static DisciplinaStudent build (DisciplinaStudentInput disciplinaStudentInput){
        System.out.println(disciplinaStudentInput);

        return DisciplinaStudent.builder().build();

    }

    public static DisciplinaStudentDTO build (DisciplinaStudent disciplinaStudent){
        return DisciplinaStudentDTO.builder().build();
    }
    
}
