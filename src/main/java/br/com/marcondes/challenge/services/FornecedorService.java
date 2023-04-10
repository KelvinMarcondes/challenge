package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.FornecedorModel;
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

    public List<FornecedorModel> findAll() {
        return repository.findAll();
    }

    public FornecedorModel findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto Não Encontrado."));
    }

    public FornecedorModel create(FornecedorModel fornecedorModel) {
        return repository.save(fornecedorModel);
    }

    public FornecedorModel update(FornecedorModel fornecedorModel) {
        var entity = findById(fornecedorModel.getId());
        entity.setRazaoSocial(fornecedorModel.getRazaoSocial());
        entity.setCnpj(fornecedorModel.getCnpj());
        entity.setEmail(fornecedorModel.getEmail());
        entity.setTelefone(fornecedorModel.getTelefone());
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
