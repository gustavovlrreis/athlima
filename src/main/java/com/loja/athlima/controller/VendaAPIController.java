package com.loja.athlima.controller;

import com.loja.athlima.model.Venda;
import com.loja.athlima.service.VendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaAPIController {
    
    @Autowired
    VendaService vendaService;
    
    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Venda> addVenda(@RequestBody Venda ven) {
        var novoVenda = vendaService.criar(ven);
        return new ResponseEntity<>(novoVenda, HttpStatus.CREATED);
    }
    
    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> Listar() {
        List<Venda> vendas = vendaService.listarTodos();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }
    
}