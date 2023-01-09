package br.lccv.ufal.treinamento.aulapratica.domains.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "Disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    @Column(name = "id")
    private UUID id;

    @Schema(description = "nome do disciplina")
    @NotBlank(message = "disciplina nao preenchido!")
    private String name;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    // @ManyToMany
    // @JoinTable(joinColumns = @JoinColumn(name = "disciplina_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    // private List<Student> student;

    @OneToMany(mappedBy = "disciplina")
    List<DisciplinaStudent> disciplinaStudents; 
    
}
