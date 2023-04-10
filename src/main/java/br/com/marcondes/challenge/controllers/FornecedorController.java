package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.model.Fornecedor;
import br.com.marcondes.challenge.services.FornecedorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @GetMapping
    public List<Fornecedor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor){
        return service.create(fornecedor);
    }

    @PutMapping
    public Fornecedor update(@RequestBody Fornecedor fornecedor){
        return service.update(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
