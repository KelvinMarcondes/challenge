package br.com.marcondes.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Funcionario extends Pessoa{
    private String rg;
    private String cpf;
    private Boolean dba;

}
