package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.FornecedorModel;
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

    public List<FornecedorModel> findAll() {
        return repository.findAll();
    }

    public FornecedorModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto Não Encontrado."));
    }

    public FornecedorModel saveFornecedor(FornecedorModel fornecedorModel) {
        return repository.save(fornecedorModel);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public boolean existsByEmail(String email){
        return repository.existsByEmail(email);
    }
    public boolean existsByTelefone(String telefone){
        return repository.existsByTelefone(telefone);
    }
    public boolean existsByCnpj(String cnpj){
        return repository.existsByCnpj(cnpj);
    }
    public boolean existsByRazaoSocial(String razaoSocial){
        return repository.existsByRazaoSocial(razaoSocial);
    }

}
