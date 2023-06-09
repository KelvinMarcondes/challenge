package br.com.marcondes.challenge.services;


import br.com.marcondes.challenge.model.ClienteModel;
import br.com.marcondes.challenge.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


    public List<ClienteModel> findAll() {
        return repository.findAll();
    }

    public ClienteModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,"Objeto não encontrado"));
    }

    public ClienteModel saveCliente(ClienteModel clienteModel) {
        return repository.save(clienteModel);
    }

    public void delete(ClienteModel clienteModel) {
        repository.delete(clienteModel);
    }


    public boolean existsByTelefone(String telefone) {
        return repository.existsByTelefone(telefone);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
