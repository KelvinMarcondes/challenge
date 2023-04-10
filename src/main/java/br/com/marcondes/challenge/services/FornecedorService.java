package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.Fornecedor;
import br.com.marcondes.challenge.repositories.FornecedorRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }


    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
