package br.luccaprado.PensadorApi.model.interfaces;

import org.jsoup.nodes.Document;

public interface Conecta {
    Document GetPensador(String complemento);
    Document GetPensador(String complemento, Integer pageNumber);
}
