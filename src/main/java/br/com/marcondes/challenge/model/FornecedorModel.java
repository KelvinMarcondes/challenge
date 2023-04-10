package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "fornecedor")
public class FornecedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column
    private String cnpj;
    @Column
    private String email;
    @Column
    private String telefone;

}


