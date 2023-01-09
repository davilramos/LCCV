package br.lccv.ufal.treinamento.aulapratica.domains.dto;

import java.util.UUID;

// import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "Representacao de um estudante.")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @Id
    @GeneratedValue(generator = "UUID")    
    private UUID id;
 

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
}
