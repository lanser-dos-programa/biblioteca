package com.bibliotecaluca.demo.service;

import com.bibliotecaluca.demo.model.Livro;
import com.bibliotecaluca.demo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro create(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> listarLivros() {
        return repository.findAll();
    }


    public void deleteById(Long id){
        repository.deleteById(id);
    }
}