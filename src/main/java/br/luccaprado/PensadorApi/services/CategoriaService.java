package br.luccaprado.PensadorApi.services;

import br.luccaprado.PensadorApi.model.entities.Categoria;
import br.luccaprado.PensadorApi.model.responses.CategoriaResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService extends BaseService {



    public List<CategoriaResponse> getCategorias(){
        Document document = GetPensador("/frases/");

        Elements elementsFull = document.getElementsByClass("block full");
        Elements elementsShort = document.getElementsByClass("block half-1");
        List<CategoriaResponse> response = new ArrayList<>();


        elementsFull.forEach(elFull-> response.add(listCat(elFull, "h2", "a")));
        elementsShort.forEach(elshort-> response.add(listCat(elshort, "h3", "a")));

        return response;




    }
    private CategoriaResponse listCat(Element el, String tagPai, String tagLink ){
        CategoriaResponse responseCategoria = new CategoriaResponse();
        Elements nomepai = el.getElementsByTag(tagPai);
        Elements links = el.getElementsByTag(tagLink);
        String pai = nomepai.first().text();
        responseCategoria.nomePai = pai;
        links.forEach(link -> {
            Categoria cat = new Categoria(link.text(), link.attr("href"));

            responseCategoria.listaCat.add(cat);

        });
        return responseCategoria;
    }


}
