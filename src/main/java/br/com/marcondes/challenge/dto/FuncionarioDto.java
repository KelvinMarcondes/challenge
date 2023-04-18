package br.com.marcondes.challenge.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FuncionarioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf;
    @NotBlank
    private String cidade;
    @NotBlank
    private String UF;
}


