package br.com.marcondes.challenge.dto;

import javax.validation.constraints.NotBlank;

public class ClienteDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf_cnpj;
    @NotBlank
    private String cidade;
    @NotBlank
    private String UF;

}
