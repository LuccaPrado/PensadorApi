package br.luccaprado.PensadorApi.model.entities;

import lombok.Data;

import java.util.List;

@Data
public class ListaCategoria {
    private String nomePai;
    private List<Categoria> categorias;
}
