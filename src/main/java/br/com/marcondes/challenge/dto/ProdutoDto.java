package br.com.marcondes.challenge.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class ProdutoDto {
    @NotBlank @NotEmpty
    private String nome;
    @NotBlank @NotEmpty
    private Double preco;
    @NotBlank @NotEmpty
    private String fornecedor;
    @NotBlank @NotEmpty
    private Integer quantidade;
    @NotBlank @NotEmpty
    private Integer quantidadeReservada;
}
