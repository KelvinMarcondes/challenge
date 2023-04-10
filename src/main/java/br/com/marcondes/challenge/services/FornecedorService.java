package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.Fornecedor;
import br.com.marcondes.challenge.repositories.FornecedorRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto Não Encontrado."));
    }

    public Fornecedor create(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor update(Fornecedor fornecedor) {
        var entity = findById(fornecedor.getId());
        entity.setRazaoSocial(fornecedor.getRazaoSocial());
        entity.setCnpj(fornecedor.getCnpj());
        entity.setEmail(fornecedor.getEmail());
        entity.setTelefone(fornecedor.getTelefone());
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
