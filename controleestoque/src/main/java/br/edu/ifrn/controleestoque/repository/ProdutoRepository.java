package br.edu.ifrn.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.controleestoque.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
