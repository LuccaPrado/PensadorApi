package br.luccaprado.PensadorApi.services;

import br.luccaprado.PensadorApi.model.entities.Categoria;
import br.luccaprado.PensadorApi.model.responses.CategoriaResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService extends BaseService {



    public List<CategoriaResponse> getCategorias(){
        Document document = GetPensador("frases/");

        Elements elementsFull = document.getElementsByClass("block full");
        Elements elementsShort = document.getElementsByClass("block half-1");
        List<CategoriaResponse> response = new ArrayList<>();
        //adiciona à resposta os elementos da lista
       response.addAll(elementsFull.stream().map(elFull -> listCat(elFull, "h2", "a")).collect(Collectors.toList()));
        response.addAll(elementsShort.stream().map(elShort -> listCat(elShort, "h3", "a")).collect(Collectors.toList()));

        return response;




    }
    private CategoriaResponse listCat(Element el, String tagPai, String tagLink ){
        CategoriaResponse responseCategoria = new CategoriaResponse();
        Elements nomepai = el.getElementsByTag(tagPai);
        Elements links = el.getElementsByTag(tagLink);
        String pai = nomepai.first().text();
        //responseCategoria.nomePai = pai;
        responseCategoria.setNomePai(pai);
        //percorre o elements pegando cada um dos objetos e jogando para uma categoria
        responseCategoria.setListaCat(links.stream().map(link -> new Categoria(link.text(), link.attr("href"))).collect(Collectors.toList()));

        return responseCategoria;
    }


}
