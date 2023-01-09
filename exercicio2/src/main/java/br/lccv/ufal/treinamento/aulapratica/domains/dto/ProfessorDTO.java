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
public class ProfessorDTO {


    @Id
    @GeneratedValue(generator = "UUID")    
    private UUID id;

    @Schema(description = "nome do professor")
    @NotBlank(message = "Nome do professor nao definido!")
    private String name;
    
}
