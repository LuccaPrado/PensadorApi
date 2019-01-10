package br.luccaprado.PensadorApi.controllers;

import br.luccaprado.PensadorApi.services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frases")
public class FrasesController {
    @Autowired
    FraseService fraseService;
    @GetMapping("{categoria}")
    public ResponseEntity<List<FraseResponse>> getFrase(@PathVariable("categoria") String categoria) {

        return ok(fraseService.getFrase());
    }
}
