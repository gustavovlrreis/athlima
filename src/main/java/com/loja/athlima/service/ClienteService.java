package com.loja.athlima.service;

import com.loja.athlima.model.Cliente;
import com.loja.athlima.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public Cliente criar(Cliente cli){
        cli.setId(null);
        clienteRepository.save(cli);
        return cli;
    }
    
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElseThrow();
    }
}
