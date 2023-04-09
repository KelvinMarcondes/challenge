package br.com.marcondes.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Pessoa {
    public Long Id;
    public String nome;
    public String lagradouro;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String cep;
    public String UF;
    public String pais;
    public Integer telefoneDdd;
    public String email;
}
