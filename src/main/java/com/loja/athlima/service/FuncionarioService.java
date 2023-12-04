package com.loja.athlima.service;

import com.loja.athlima.model.Funcionario;
import com.loja.athlima.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    public Funcionario criar(Funcionario fun){
        fun.setId(null);
        funcionarioRepository.save(fun);
        return fun;
    }
    
    public Funcionario buscarPorId(Integer id) {
        return funcionarioRepository.findById(id).orElseThrow();
    }
}
