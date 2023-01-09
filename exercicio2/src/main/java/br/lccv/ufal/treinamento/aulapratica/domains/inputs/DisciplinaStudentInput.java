package br.lccv.ufal.treinamento.aulapratica.domains.inputs;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema (description = "Representacao do cadastro")
public class DisciplinaStudentInput {

    @Schema(description = "Id da estudante")
    // @NotBlank(message = "Student nao preenchido!")
    private UUID studentId;

    @Schema(description = "Id da disciplina")
    // @NotBlank(message = "Disciplina nao preenchido!")
    private UUID disciplinaId;
    
}
