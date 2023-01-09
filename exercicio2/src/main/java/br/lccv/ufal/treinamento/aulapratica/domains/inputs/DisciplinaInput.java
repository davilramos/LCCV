package br.lccv.ufal.treinamento.aulapratica.domains.inputs;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema (description = "Representacao do disciplina")
public class DisciplinaInput {

    @Schema(description = "nome da disciplina")
    @NotBlank(message = "professor nao preenchido!")
    private String name;

    private UUID professorId;
    
}

