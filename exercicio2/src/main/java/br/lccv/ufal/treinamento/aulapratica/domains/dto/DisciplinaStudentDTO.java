package br.lccv.ufal.treinamento.aulapratica.domains.dto;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "Representacao de um Cadastro.")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaStudentDTO {

    @Id
    @GeneratedValue(generator = "UUID")    
    private UUID id;
 
    // @Schema(description = "Id da estudante")
    // @NotBlank(message = "professor nao preenchido!")
    // private UUID studentId;

    // @Schema(description = "Id da disciplina")
    // @NotBlank(message = "professor nao preenchido!")
    // private UUID disciplinaId;
}
