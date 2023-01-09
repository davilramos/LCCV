package br.lccv.ufal.treinamento.aulapratica.domains.inputs;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema (description = "Representacao do estudante")
public class StudentInput {
    
    @Schema(description = "cpf do estudante")
    @NotBlank(message = "CPF nao preenchido!")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    private String cpf;
    
    @Schema(description = "nome do estudante")
    @NotBlank(message = "Nome nao preenchido!")
    private String name;

    @Schema(description = "idade do estudante")
    @Min(value = 18, message = "Idade tem quer ser maior que 18!")
    private Integer age;

    private UUID courseId;

    // private UUID disciplinaId;
}
