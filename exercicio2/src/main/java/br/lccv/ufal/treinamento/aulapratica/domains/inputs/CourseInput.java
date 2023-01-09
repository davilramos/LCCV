package br.lccv.ufal.treinamento.aulapratica.domains.inputs;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema (description = "Representacao do Curso")
public class CourseInput {

    @Schema(description = "nome do curso")
    @NotBlank(message = "curso nao preenchido!")
    private String name;
    
}
