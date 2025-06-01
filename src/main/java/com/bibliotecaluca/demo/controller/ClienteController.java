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
        return ResponseEntity.created(URI.create("/create"+create.getId())).body(create);
    }

    @GetMapping("/view")
    public ResponseEntity<List<Cliente>>listarCliente() {
        return ResponseEntity.ok(service.listarCliente());
    }


}