package com.loja.athlima.controller;

import com.loja.athlima.model.Funcionario;
import com.loja.athlima.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioAPIController {
    
    @Autowired
    FuncionarioService funcionarioService;
    
    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario fun) {
        var novoFuncionario = funcionarioService.criar(fun);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }
    
}
