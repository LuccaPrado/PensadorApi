package br.luccaprado.PensadorApi.services;

import br.luccaprado.PensadorApi.model.entities.Autor;
import br.luccaprado.PensadorApi.model.entities.Texto;
import br.luccaprado.PensadorApi.model.responses.ListaFrasesResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FraseService extends BaseService  {

    public ListaFrasesResponse getListaFrases(String categoriaUrl){
        ListaFrasesResponse listaFrasesResponse = new ListaFrasesResponse();
        Document document = GetPensador(categoriaUrl);

        return percorre(document);
    }
    public ListaFrasesResponse getListaFrases(String categoriaUrl, Integer pagenum){

        Document document = GetPensador(categoriaUrl, pagenum);
        return percorre(document);

    }
    private ListaFrasesResponse percorre(Document document){
        ListaFrasesResponse listaFrasesResponse = new ListaFrasesResponse();
        Elements lista = document.getElementsByClass("thought-card");
        lista.forEach(elemento -> pegaFrases(elemento, listaFrasesResponse));
        return listaFrasesResponse;
    }
    private ListaFrasesResponse pegaFrases(Element elemento, ListaFrasesResponse listaFrasesResponse){

        Texto texto = new Texto();
        Autor autor = new Autor();
        texto.setTexto(elemento.getElementsByTag("p").text());
        autor.setNome(elemento.getElementsByClass("autor").select("a").text());
        texto.setAutor(autor);
        texto.setImagemUrl(elemento.getElementsByClass("linkDetailImage").attr("href"));
        texto.setCompartilhamentos(elemento.getElementsByClass("total-shares").text());
        listaFrasesResponse.lista.add(texto);
        return listaFrasesResponse;
    }


}
