package br.luccaprado.PensadorApi.services;
import br.luccaprado.PensadorApi.model.interfaces.Conecta;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;

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
}
