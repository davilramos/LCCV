package br.lccv.ufal.treinamento.aulapratica.domains.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    private UUID id;

    @Schema(description = "nome do estudante")
    // @NotBlank(message = "Nome nao preenchido!")
    private String name;

    @Schema(description = "idade do estudante")
    @Min(value = 18, message = "Idade tem quer ser maior que 18!")
    private Integer age;

    @Schema(description = "cpf do estudante")
    // @NotBlank(message = "CPF nao preenchido!")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    private String cpf;

    @ManyToOne
    private Course course;

    // @ManyToMany(mappedBy = "student")
    // private List<Disciplina> disciplina;

    @OneToMany(mappedBy = "student")
    List<DisciplinaStudent> disciplinaStudents; 
    
}
