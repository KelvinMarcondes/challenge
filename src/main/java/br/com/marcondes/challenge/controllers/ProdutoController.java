package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.model.Produto;
import br.com.marcondes.challenge.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public List<Produto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return service.create(produto);
    }

    @PutMapping
    public Produto update(@RequestBody Produto produto){
        return service.update(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
