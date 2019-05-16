package br.luccaprado.PensadorApi.controllers;

import br.luccaprado.PensadorApi.model.responses.ListaFrasesResponse;
import br.luccaprado.PensadorApi.services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/frases")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class FrasesController {
    @Autowired
    FraseService fraseService;
    @GetMapping("/{categoriaUrl}")
    public ResponseEntity<ListaFrasesResponse> getListaFrase(@PathVariable("categoriaUrl") String categoriaUrl) {
        return ok(fraseService.getListaFrases(categoriaUrl));
    }
    @GetMapping("/{categoriaUrl}/{pagNum}")
    public ResponseEntity<ListaFrasesResponse> getListaFrase(@PathVariable("categoriaUrl") String categoriaUrl, @PathVariable("pagNum") Integer pagNum) {
        return ok(fraseService.getListaFrases(categoriaUrl, pagNum));
    }
    @GetMapping("/buscar/{palavra}/{pagNum}")
    public ResponseEntity<ListaFrasesResponse> getBuscaFrase(@PathVariable("palavra") String palavra, @PathVariable("pagNum") Integer pagNum) {
        return ok(fraseService.getBuscaFrases(palavra, pagNum));
    }


}
