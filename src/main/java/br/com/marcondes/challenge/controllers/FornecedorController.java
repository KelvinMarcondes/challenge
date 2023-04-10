package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.model.FornecedorModel;
import br.com.marcondes.challenge.services.FornecedorService;
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
    public List<FornecedorModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FornecedorModel findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public FornecedorModel create(@RequestBody FornecedorModel fornecedorModel){
        return service.create(fornecedorModel);
    }

    @PutMapping
    public FornecedorModel update(@RequestBody FornecedorModel fornecedorModel){
        return service.update(fornecedorModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
