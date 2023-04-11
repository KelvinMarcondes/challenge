package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.ProdutoModel;
import br.com.marcondes.challenge.repositories.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoModel> findAll(){
        return repository.findAll();
    }

    public ProdutoModel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto não encontrado"));
    }

    public ProdutoModel save(ProdutoModel produtoModel) {
        return repository.save(produtoModel);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
