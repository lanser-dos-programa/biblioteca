package com.bibliotecaluca.demo.repository;

import com.bibliotecaluca.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainingIgnoreCase(String Nome);

    List<Cliente> findByEmailContainingIgnoreCase(String email);

    List<Cliente> findByCpfContainingIgnoreCase(String cpf);

    List<Cliente> findByEnderecoContainingIgnoreCase(String endereco);
}
