package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.dto.FornecedorDto;
import br.com.marcondes.challenge.dto.FuncionarioDto;
import br.com.marcondes.challenge.model.FuncionarioModel;
import br.com.marcondes.challenge.services.FuncionarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<FuncionarioModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        if (service.existsByTelefone(funcionarioDto.getTelefone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Telefone já utilizado.");
        } if (service.existsByCpf(funcionarioDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já utilizado.");
        } if (service.existsByEmail(funcionarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já utilizado.");
        }
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveFuncionario(funcionarioModel));
    }

    @PutMapping
    public ResponseEntity<Object> update(@PathVariable(value = "id")Long id,
                                         @RequestBody FornecedorDto fornecedorDto){
        Optional<FuncionarioModel> funcionarioModelOptional = Optional.ofNullable(service.findById(id));
        if (funcionarioModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(fornecedorDto, funcionarioModel);
        funcionarioModel.setId(funcionarioModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.saveFuncionario(funcionarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
        Optional<FuncionarioModel> funcionarioModelOptional = Optional.ofNullable(service.findById(id));
        if (funcionarioModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
        service.delete(funcionarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Funcionário deletado.");
    }

}
