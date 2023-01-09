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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Entity
public class DisciplinaDTO {


    @Id
    @GeneratedValue(generator = "UUID")    
    private UUID id;

    @Schema(description = "nome do disciplina")
    @NotBlank(message = "Nome do disciplina nao definido!")
    private String name;
    
}
