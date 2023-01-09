package br.lccv.ufal.treinamento.aulapratica.domains.inputs;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema (description = "Representacao do professor")
public class ProfessorInput {

    @Schema(description = "nome do professor")
    @NotBlank(message = "professor nao preenchido!")
    private String name;
    
}

