package br.gov.sp.fatec.springtopicos20242.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.sp.fatec.springtopicos20242.entity.Trabalho;
import br.gov.sp.fatec.springtopicos20242.service.TrabalhoService;

@RestController
@RequestMapping("/trabalho")
@CrossOrigin
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public ResponseEntity<Trabalho> cadastrar(@RequestBody Trabalho trabalho) {
        Trabalho novoTrabalho = trabalhoService.cadastrar(trabalho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTrabalho);
    }

    @GetMapping
    public ResponseEntity<List<Trabalho>> listarTodos() {
        List<Trabalho> trabalhos = trabalhoService.listarTodos();
        return ResponseEntity.ok(trabalhos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Trabalho>> buscarPorTituloENota(
            @RequestParam String palavra,
            @RequestParam int nota) {
        List<Trabalho> trabalhos = trabalhoService.buscarPorTituloENota(palavra, nota);
        return ResponseEntity.ok(trabalhos);
    }
}
