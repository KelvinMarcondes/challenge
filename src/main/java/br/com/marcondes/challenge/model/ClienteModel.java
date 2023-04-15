package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String sobreNome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String cpf;

    @Column
    private String cidade;

    @Column
    private String UF;
}
