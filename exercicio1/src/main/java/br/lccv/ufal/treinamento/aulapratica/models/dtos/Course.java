package br.lccv.ufal.treinamento.aulapratica.models.dtos;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Entity
public class Course {

    @NotBlank(message = "Nome do curso nao definido!")
    private String name;

    // @Id
    // @GeneratedValue(generator = "UUID")   
    // private UUID id;

    private Integer id;
    
}
