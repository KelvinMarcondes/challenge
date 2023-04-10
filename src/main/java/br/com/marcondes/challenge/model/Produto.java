package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column
    private String nome;
    @Column
    private Double preco;
    @Column
    private String fornecedor;
    @Column
    private Integer quantidade;
    @Column(name = "quantidade_reservada")
    private Integer quantidadeReservada;
}
