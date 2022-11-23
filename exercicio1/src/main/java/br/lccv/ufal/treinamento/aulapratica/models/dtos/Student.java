package br.lccv.ufal.treinamento.aulapratica.models.dtos;

// import java.util.UUID;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

// import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

// import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Entity
public class Student {

    // @Id
    // @GeneratedValue(generator = "UUID")    
    // private UUID id;
 
    private Integer id;

    @NotBlank(message = "CPF nao preenchido!")
    private String cpf;
    
    @NotBlank(message = "Nome nao preenchido!")
    private String name;

    @Min(value = 18, message = "Idade tem quer ser maior que 18!")
    private Integer age;
}
