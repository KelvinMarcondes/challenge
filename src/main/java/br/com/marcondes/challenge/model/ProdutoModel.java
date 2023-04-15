package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoModel implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
