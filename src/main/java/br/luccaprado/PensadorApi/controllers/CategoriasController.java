package br.luccaprado.PensadorApi.controllers;

import br.luccaprado.PensadorApi.model.responses.CategoriaResponse;
import br.luccaprado.PensadorApi.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getCategorias() {

        return ok(categoriaService.getCategorias());
    }
}
