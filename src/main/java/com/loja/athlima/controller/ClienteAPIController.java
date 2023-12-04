package com.loja.athlima.controller;

import com.loja.athlima.model.Cliente;
import com.loja.athlima.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteAPIController {
    
    @Autowired
    ClienteService clienteService;
    
    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cli) {
        var novoCliente = clienteService.criar(cli);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
}
