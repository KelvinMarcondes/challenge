package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column
    private String cnpj;
    @Column
    private String email;
    @Column
    private String telefone;

}


