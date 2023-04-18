package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.FuncionarioModel;
import br.com.marcondes.challenge.repositories.FuncionarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioModel> findAll() {
        return repository.findAll();
    }

    public FuncionarioModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto Não Encontrado."));
    }

    public FuncionarioModel saveFuncionario(FuncionarioModel funcionarioModel) {
        return repository.save(funcionarioModel);
    }

    public void delete(FuncionarioModel funcionarioModel) {
        repository.delete(funcionarioModel);
    }

    public boolean existsByCpf(String cpf){
        return repository.existsByCpf(cpf);
    }
    public boolean existsByEmail(String email){
        return repository.existsByEmail(email);
    }
    public boolean existsByTelefone(String telefone){
        return repository.existsByTelefone(telefone);
    }
}
