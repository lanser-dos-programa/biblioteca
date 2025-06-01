package com.bibliotecaluca.demo.repository;

import com.bibliotecaluca.demo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByAutorContainingIgnoreCase(String autor);

    List<Livro> findByGeneroContainingIgnoreCase(String genero);

    List<Livro> findByAutorAndGenero(String autor, String genero);
}
