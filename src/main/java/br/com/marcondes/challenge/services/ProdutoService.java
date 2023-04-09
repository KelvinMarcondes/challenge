package br.com.marcondes.challenge.services;

import br.com.marcondes.challenge.model.Produto;
import br.com.marcondes.challenge.repositories.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Objeto não encontrado"));
    }

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto produto) {
        var entity = findById(produto.getId());
        entity.setFornecedor(produto.getFornecedor());
        entity.setNome(produto.getNome());
        entity.setPreco(produto.getPreco());
        entity.setQuantidade(produto.getQuantidade());
        entity.setQuantidadeReservada(produto.getQuantidadeReservada());
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
