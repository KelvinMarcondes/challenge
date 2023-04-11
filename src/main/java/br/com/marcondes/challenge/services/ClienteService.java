package br.com.marcondes.challenge.services;


import br.com.marcondes.challenge.model.ClienteModel;
import br.com.marcondes.challenge.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,"Objeto aão encontrado"));
    }

    public ClienteModel save(ClienteModel clienteModel) {
        return repository.save(clienteModel);
    }

    public void delete(ClienteModel clienteModel) {
        repository.delete(clienteModel);

    }

}
