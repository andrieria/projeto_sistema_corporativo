package br.edu.ifrn.controleestoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.controleestoque.domain.categoria.Categoria;
import br.edu.ifrn.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public void salvar(@RequestBody Categoria categoria){
        categoriaRepository.save(categoria);
    } 
    
}
