package com.bibliotecaluca.demo.service;

import com.bibliotecaluca.demo.model.Cliente;
import com.bibliotecaluca.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return repository.findById(id)
                .map(clienteExistente -> {
                    if (clienteAtualizado.getNome() != null) {
                        clienteExistente.setNome(clienteAtualizado.getNome());
                    }
                    if (clienteAtualizado.getEmail() != null) {
                        clienteExistente.setEmail(clienteAtualizado.getEmail());
                    }
                    if (clienteAtualizado.getCpf() != null){
                        clienteExistente.setCpf(clienteAtualizado.getCpf());
                    }
                    if (clienteAtualizado.getEndereco() != null){
                        clienteExistente.setEndereco(clienteAtualizado.getEndereco());
                    }
                    if (clienteAtualizado.getSenha() != null){
                        clienteExistente.setSenha(clienteAtualizado.getSenha());
                    }
                    return repository.save(clienteExistente);
                })
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + id));
    }
}
