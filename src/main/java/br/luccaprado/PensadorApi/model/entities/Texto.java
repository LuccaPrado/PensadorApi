package br.luccaprado.PensadorApi.model.entities;

import lombok.Data;

@Data
public class Texto {
    protected String texto;
    protected String compartilhamentos;
    //todo incluir em coleção
    protected String imagemUrl;
    private Autor autor;
    private String nomeUser;
    private String userUrl;
}
