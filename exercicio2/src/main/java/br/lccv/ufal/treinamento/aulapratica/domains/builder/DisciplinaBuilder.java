package br.lccv.ufal.treinamento.aulapratica.domains.builder;

import java.util.LinkedList;
import java.util.List;
import br.lccv.ufal.treinamento.aulapratica.domains.dto.DisciplinaDTO;
import br.lccv.ufal.treinamento.aulapratica.domains.inputs.DisciplinaInput;
import br.lccv.ufal.treinamento.aulapratica.domains.models.Disciplina;

public class DisciplinaBuilder {
    public static Disciplina build (DisciplinaInput input){
        return Disciplina.builder()
        .name(input.getName())
        .build();
    }

    public static DisciplinaDTO build (Disciplina disciplina){
        return DisciplinaDTO.builder()
                .name(disciplina.getName())
                .id(disciplina.getId())
                .build();
    }

    public static List<DisciplinaDTO> build (List<Disciplina> disciplinas){
        
        List<DisciplinaDTO> finalList = new LinkedList<>();
        for (Disciplina disciplina : disciplinas){
            DisciplinaDTO disciplinaDTO = build(disciplina);
            finalList.add(disciplinaDTO);
        }

        return finalList;
    }
}
