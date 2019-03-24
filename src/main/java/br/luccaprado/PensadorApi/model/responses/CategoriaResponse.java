package br.luccaprado.PensadorApi.model.responses;

import br.luccaprado.PensadorApi.model.entities.Categoria;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriaResponse {
    public String nomePai;
    public List<Categoria> listaCat = new ArrayList<>();


}
