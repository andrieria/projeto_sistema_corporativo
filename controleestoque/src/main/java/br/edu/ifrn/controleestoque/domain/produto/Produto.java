package br.edu.ifrn.controleestoque.domain.produto;

import java.math.BigDecimal;

import br.edu.ifrn.controleestoque.domain.categoria.Categoria;
import br.edu.ifrn.controleestoque.domain.fabricante.Fabricante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "produto")
@Entity(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")


public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank //(message = "Mensagem de erro")

    private String nome;
    private String descricao;
    @NotNull
    private int quantidadeEstoque;
    @NotNull
    private BigDecimal preco;
    

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="fabricante_id")
    private Fabricante fabricante;

}
