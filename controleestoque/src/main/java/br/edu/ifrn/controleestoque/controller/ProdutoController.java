package br.edu.ifrn.controleestoque.controller;

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

import br.edu.ifrn.controleestoque.domain.produto.Produto;
import br.edu.ifrn.controleestoque.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private ProdutoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder){
        Produto produtoLocal = repository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    } 

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id) {
        Produto produto = repository.getReferenceById(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listar(@PageableDefault(size=4, sort = {"nome"}) Pageable paginacao){
         var produtos = repository.findAll(paginacao);
         return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Produto> atualizar (@RequestBody @Valid Produto produto) {
        Produto produtoLocal = repository.findById(produto.getId()).get();
        produtoLocal.setNome(produto.getNome());
        return ResponseEntity.ok(produtoLocal);
    }
    
}

