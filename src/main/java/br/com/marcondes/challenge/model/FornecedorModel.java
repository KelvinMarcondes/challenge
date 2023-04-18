package br.com.marcondes.challenge.model;

import br.com.marcondes.challenge.model.enums.MatrizOuFilial;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fornecedores")
public class FornecedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social", unique = true)
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "matriz_filial")
    private MatrizOuFilial matrizOuFilial;

    @Column(unique = true)
    private String cnpj;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;

}


