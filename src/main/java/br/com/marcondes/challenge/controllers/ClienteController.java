package br.com.marcondes.challenge.controllers;

import br.com.marcondes.challenge.dto.ClienteDto;
import br.com.marcondes.challenge.model.ClienteModel;
import br.com.marcondes.challenge.services.ClienteService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Data
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto){
        if (service.existsByCpf(clienteDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já utilizado");
        }
        if (service.existsByTelefone(clienteDto.getTelefone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Telefone já utilizado.");
        }
        if (service.existsByEmail(clienteDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já utilizado.");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCliente(clienteModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id")Long id,
                                                @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = Optional.ofNullable(service.findById(id));

        if (clienteModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.saveCliente(clienteModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
        Optional<ClienteModel> clienteModelOptional = Optional.ofNullable(service.findById(id));
        if (clienteModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        service.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente deletado.");

    }

}
