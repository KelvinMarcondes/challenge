package br.com.marcondes.challenge.repositories;

import br.com.marcondes.challenge.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);
    boolean existsByCnpj(String cnpj);
    boolean existsByRazaoSocial(String razaoSocial);
}
