package br.lccv.ufal.treinamento.aulapratica.domains.builder;

import java.util.LinkedList;
import java.util.List;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.ProfessorDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.ProfessorInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Professor;

public class ProfessorBuilder {
    public static Professor build (ProfessorInput input){
        return Professor.builder()
        .name(input.getName())
        .build();
    }

    public static ProfessorDTO build (Professor professor){
        return ProfessorDTO.builder()
                .name(professor.getName())
                .id(professor.getId())
                .build();
    }

    public static List<ProfessorDTO> build (List<Professor> professors){
        
        List<ProfessorDTO> finalList = new LinkedList<>();
        for (Professor professor : professors){
            ProfessorDTO professorDTO = build(professor);
            finalList.add(professorDTO);
        }

        return finalList;
    }
}
