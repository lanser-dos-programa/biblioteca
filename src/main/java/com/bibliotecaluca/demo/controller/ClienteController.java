package com.bibliotecaluca.demo.controller;

import com.bibliotecaluca.demo.model.Cliente;
import com.bibliotecaluca.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Cliente> create(@RequestBody @Validated  Cliente cliente){
        Cliente create = service.create(cliente);
        return ResponseEntity.created(URI.create("/create/"+create.getId())).body(create);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<List<Cliente>> listarCliente() {
        return ResponseEntity.ok(service.listarCliente());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Validated Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody @Validated Cliente clienteAtualizado) {
        Cliente salvarCLiente = service.atualizarCliente(id, clienteAtualizado);
        if (!id.equals(clienteAtualizado.getId())) {
            return ResponseEntity.ok(clienteAtualizado);

        }
        return ResponseEntity.badRequest().build();
    }
}