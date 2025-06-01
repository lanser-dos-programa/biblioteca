package com.bibliotecaluca.demo.controller;

import com.bibliotecaluca.demo.model.Livro;
import com.bibliotecaluca.demo.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Livro> create(@RequestBody @Validated Livro livro) {
        Livro create = service.create(livro);
        return ResponseEntity.created(URI.create("/create"+create.getId())).body(create);
    }

    @GetMapping("/view")
    public ResponseEntity<List<Livro>>listarLivros() {
        return ResponseEntity.ok(service.listarLivros());
    }
}