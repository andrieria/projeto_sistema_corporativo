package br.edu.ifrn.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.controleestoque.domain.categoria.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
