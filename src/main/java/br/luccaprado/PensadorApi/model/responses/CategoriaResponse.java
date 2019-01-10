package br.luccaprado.PensadorApi.model.responses;

import br.luccaprado.PensadorApi.model.entities.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaResponse {
    public String nomePai;
    public List<Categoria> listaCat = new ArrayList<>();


}
