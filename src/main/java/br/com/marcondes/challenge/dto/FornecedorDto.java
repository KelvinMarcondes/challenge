package br.com.marcondes.challenge.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FornecedorDto {

    @NotBlank
    private String razaoSocial;

    @NotBlank
    private String nomeFantasia;

    @NotBlank
    private String matrizOuFilial;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

}
