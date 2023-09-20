package br.edu.ifrn.controleestoque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifrn.controleestoque.domain.categoria.Categoria;
import br.edu.ifrn.controleestoque.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Categoria categoria, UriComponentsBuilder uriBuilder){
        Categoria categoriaLocal = categoriaRepository.save(categoria);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoriaLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    } 

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id) {
        var categoria = categoriaRepository.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> listar(@PageableDefault(size=4, sort = {"nome"}) Pageable paginacao){
         var categorias = categoriaRepository.findAll(paginacao);
         return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        categoriaRepository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizar (@RequestBody Categoria categoria) {
        var categoriaLocal = categoriaRepository.getReferenceById(categoria.getId());
        categoriaRepository.save(categoriaLocal);
        return ResponseEntity.ok(categoriaLocal);
    }
    
}
