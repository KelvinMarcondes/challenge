package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private String cpf;
    @Column
    private String cidade;
    @Column(name = "uf")
    private String UF;
    @Column
    private Boolean admin;
}
