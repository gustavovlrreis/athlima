package com.loja.athlima.controller;

import com.loja.athlima.model.Cliente;
import com.loja.athlima.model.Funcionario;
import com.loja.athlima.model.Venda;
import com.loja.athlima.service.ClienteService;
import com.loja.athlima.service.FuncionarioService;
import com.loja.athlima.service.VendaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeralController {
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    FuncionarioService funcionarioService;
    
    @Autowired
    VendaService vendaService;
    
    @GetMapping("/inserir-cliente")
    public String cadastroClienteForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cadastroCliente";
    }
    
    @GetMapping("/inserir-funcionario")
    public String cadastroFuncionarioForm(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "cadastroFuncionario";
    }
    
    @GetMapping("/inserir-venda")
    public String cadastroForm(Model model){
        model.addAttribute("venda", new Venda());
        return "cadastroVenda";
    }
    
    @GetMapping("/listagem")
    public String listaForm(Model model){
        model.addAttribute("lista", vendaService.listarTodos());
        return "relatorioVendas";
    }
    
    @GetMapping("/area-usuario")
    public String mostraAreaUsuario(Model model){
        return "areaUsuario";
    }
    
    @PostMapping("/gravar-venda")
    public String gravarVenda(@ModelAttribute Venda venda, Model model) {
        
        vendaService.criar(venda);
        return "redirect:/listagem";
    }
    
    @PostMapping("/gravar-cliente")
    public String gravarCliente(@ModelAttribute Cliente cliente, Model model) {
        
        clienteService.criar(cliente);
        return "redirect:/area-usuario";
    }
    
    @PostMapping("/gravar-funcionario")
    public String gravarFuncionario(@ModelAttribute Funcionario funcionario, Model model) {
        
        funcionarioService.criar(funcionario);
        return "redirect:/area-usuario";
    }
    
}
