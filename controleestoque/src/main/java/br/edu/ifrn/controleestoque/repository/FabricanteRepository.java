package br.edu.ifrn.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.controleestoque.domain.fabricante.Fabricante;

public interface FabricanteRepository extends JpaRepository <Fabricante, Long>{
    
}
