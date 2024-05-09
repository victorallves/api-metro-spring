package br.com.magna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.FuncionarioDTO;
import br.com.magna.model.Funcionario;
import br.com.magna.repository.FuncionarioRepository;
import br.com.magna.service.FuncionarioService;


@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionariosController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
    private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	@GetMapping("/detalhes")
	public List<FuncionarioDTO> getAllFuncionariosComDetalhes() {
		return funcionarioService.getAllFuncionariosComDetalhes();
	}

	@GetMapping("/{id}")
	public Funcionario getFuncionarioById(@PathVariable Long id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
	}

	@PostMapping
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
		return funcionarioRepository.findById(id).map(funcionario -> {
			funcionario.setNome(funcionarioAtualizado.getNome());
			funcionario.setCargo(funcionarioAtualizado.getCargo());
			funcionario.setSalario(funcionarioAtualizado.getSalario());
			funcionario.setLinha(funcionarioAtualizado.getLinha());
			funcionario.setVeiculo(funcionarioAtualizado.getVeiculo());
			return funcionarioRepository.save(funcionario);
		}).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
	}
}