package br.luccaprado.PensadorApi.services;

import br.luccaprado.PensadorApi.model.interfaces.Conecta;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BaseService implements Conecta {


    final static String baseUrl = "https://www.pensador.com/";

    @Override
    public Document GetPensador(String complemento) {
        try {
            return Jsoup.connect(baseUrl+complemento).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Document GetPensador(String complemento, Integer pageNumber) {

        try {
            return Jsoup.connect(baseUrl+complemento+"/"+pageNumber).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Document GetPensador(String complemento, Integer pageNumber, Boolean pesquisa) {

        try {
            Document req =Jsoup.connect(baseUrl+"busca.php?q="+complemento+"&?p="+pageNumber).get();
            if(req.baseUri().contains("buscar.php")) {
                return req;
            }else {
                return Jsoup.connect(req.baseUri()+pageNumber).get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
