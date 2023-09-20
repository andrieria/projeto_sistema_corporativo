package br.edu.ifrn.controleestoque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.edu.ifrn.controleestoque.domain.categoria.Categoria;
import br.edu.ifrn.controleestoque.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public void salvar(@RequestBody Categoria categoria){
        categoriaRepository.save(categoria);
    } 

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id) {
        var categoria = categoriaRepository.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> listar(Pageable paginacao){
         var categorias = categoriaRepository.findAll(paginacao);
         return ResponseEntity.ok(categorias);
    }
    
}
