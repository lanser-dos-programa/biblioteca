package com.bibliotecaluca.demo.repository;

import com.bibliotecaluca.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
