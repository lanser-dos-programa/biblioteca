package com.bibliotecaluca.demo.controller;

import com.bibliotecaluca.demo.model.Cliente;
import com.bibliotecaluca.demo.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public final ClienteService service;

    public Controller(ClienteService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public Cliente create(Cliente cliente){
        return create(cliente);
    }

}
