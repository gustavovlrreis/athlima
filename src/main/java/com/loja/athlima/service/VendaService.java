package com.loja.athlima.service;

import com.loja.athlima.model.Venda;
import com.loja.athlima.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    
    @Autowired
    VendaRepository vendaRepository;
    
    public Venda criar(Venda ven){
        ven.setId(null);
        vendaRepository.save(ven);
        return ven;
    }
    
    public Venda buscarPorId(Integer id) {
        return vendaRepository.findById(id).orElseThrow();
    }
    
    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }
}