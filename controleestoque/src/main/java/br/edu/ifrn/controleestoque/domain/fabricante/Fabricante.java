package br.edu.ifrn.controleestoque.domain.fabricante;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "fabricante") //Nome usado em consultas SQL
@Entity(name="fabricante") //Nome usado nas consultas JPQL (solução JPA)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //No caso de PostgreSQl, seria GenerationType.SEQUENCE
    private Long id;
    @NotBlank
    private String nome;

    //Caso necessário devolver produtos, seria com esta anotação 
    //@OneToMany(mappedBy = "fabricante")
    //List<Produto> produtos;

    
}
