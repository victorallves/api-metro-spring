package br.com.magna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.FuncionarioDTO;
import br.com.magna.service.FuncionarioService;

@RestController
public class CadastroFuncionarioController {

    private final FuncionarioService cadastroService;

    @Autowired
    public CadastroFuncionarioController(FuncionarioService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/cadastrar")
    public void cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        cadastroService.cadastrarFuncionarioComLinhaEVeiculo(funcionarioDTO);
    }
    
}
