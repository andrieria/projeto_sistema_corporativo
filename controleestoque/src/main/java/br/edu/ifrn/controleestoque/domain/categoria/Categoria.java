package br.edu.ifrn.controleestoque.domain.categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="categoria")
@Table(name="categoria")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
}
