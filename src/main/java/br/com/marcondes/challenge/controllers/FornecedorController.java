package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.dto.FornecedorDto;
import br.com.marcondes.challenge.model.FornecedorModel;
import br.com.marcondes.challenge.services.FornecedorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity <List<FornecedorModel>>findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> saveFornecedor(@RequestBody FornecedorDto fornecedorDto){
        if (service.existsByRazaoSocial(fornecedorDto.getRazaoSocial())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Razao Social já utilizada.");
        } if (service.existsByCnpj(fornecedorDto.getCnpj())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CNPJ já utilizado.");
        } if (service.existsByTelefone(fornecedorDto.getTelefone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Telefone já utilizado.");
        } if (service.existsByEmail(fornecedorDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já utilizado.");
        }
        var fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto, fornecedorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveFornecedor(fornecedorModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")Long id,
                                         @RequestBody  FornecedorDto fornecedorDto){
        Optional<FornecedorModel> fornecedorModelOptional = Optional.ofNullable(service.findById(id));
        if (fornecedorModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        var fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto, fornecedorModel);
        fornecedorModel.setId(fornecedorModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.saveFornecedor(fornecedorModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
