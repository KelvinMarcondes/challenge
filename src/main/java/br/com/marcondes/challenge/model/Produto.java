package br.com.marcondes.challenge.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {

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
