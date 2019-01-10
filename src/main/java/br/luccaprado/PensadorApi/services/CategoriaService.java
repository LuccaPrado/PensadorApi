package br.luccaprado.PensadorApi.services;

import br.luccaprado.PensadorApi.model.entities.Categoria;
import br.luccaprado.PensadorApi.model.responses.CategoriaResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService extends BaseService {



    public List<CategoriaResponse> getCategorias(){
        try {
            Document document = Jsoup.connect(baseUrl+"/frases/").get();

            Elements elementsFull = document.getElementsByClass("block full");
            Elements elementsShort = document.getElementsByClass("block half-1");
            List<CategoriaResponse> response = new ArrayList<>();


            elementsFull.forEach(elFull-> {
                CategoriaResponse responseCategoria = new CategoriaResponse();
                Elements nomepai = elFull.getElementsByTag("h2");
                Elements links = elFull.getElementsByTag("a");
                String pai = nomepai.first().text();
                responseCategoria.nomePai = pai;
                links.forEach(link -> {
                    Categoria cat = new Categoria(link.text(), link.attr("href"));

                    responseCategoria.listaCat.add(cat);

                });
                response.add(responseCategoria);

            });
            elementsShort.forEach(elshort-> {
                CategoriaResponse responseCategoria = new CategoriaResponse();
                Elements nomepai = elshort.getElementsByTag("h3");
                Elements links = elshort.getElementsByTag("a");
                String pai = nomepai.first().text();
                responseCategoria.nomePai = pai;
                links.forEach(link -> {
                    Categoria cat = new Categoria(link.text(), link.attr("href"));

                    responseCategoria.listaCat.add(cat);

                });
                response.add(responseCategoria);

            });




            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }





        return null;

    }
}
