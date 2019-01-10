package br.luccaprado.PensadorApi.model.entities;

import lombok.Data;

@Data
public class Categoria {

    private String nome;
    private String url;

    public Categoria(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }
}
