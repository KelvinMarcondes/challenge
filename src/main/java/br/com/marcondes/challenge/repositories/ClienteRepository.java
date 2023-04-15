package br.com.marcondes.challenge.repositories;

import br.com.marcondes.challenge.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);
    boolean existsByCpf(String cpf);


}
