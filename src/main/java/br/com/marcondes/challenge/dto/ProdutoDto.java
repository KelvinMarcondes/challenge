package br.com.marcondes.challenge.dto;

import br.com.marcondes.challenge.model.enums.EstoqueDisponivel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProdutoDto {
    @NotNull
    private String nome;
    @NotNull
    private Double preco;
    @NotNull
    private Integer quantidade;
    @NotNull
    private EstoqueDisponivel estoqueDisponivel;
}
