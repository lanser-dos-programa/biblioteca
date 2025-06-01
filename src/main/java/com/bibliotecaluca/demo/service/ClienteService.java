package com.bibliotecaluca.demo.service;

import com.bibliotecaluca.demo.model.Cliente;
import com.bibliotecaluca.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {
    public final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente create(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listarCliente(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
