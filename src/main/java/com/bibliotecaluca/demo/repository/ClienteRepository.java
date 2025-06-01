package com.bibliotecaluca.demo.repository;

import com.bibliotecaluca.demo.model.Cliente;
import com.bibliotecaluca.demo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Livro> findByNomeContainingIgnoreCase(String Nome);

    List<Livro> findByEmailContainingIgnoreCase(String email);

    List<Livro> findByCpfContainingIgnoreCase(String cpf);

    List<Livro> findByEnderecoContainingIgnoreCase(String endereco);
}
