package br.com.magna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.model.Veiculo;
import br.com.magna.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculoById(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
    }

    @PostMapping
    public Veiculo addVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoRepository.findById(id)
                .map(veiculo -> {
                    veiculo.setTipo(veiculoAtualizado.getTipo());
                    veiculo.setModelo(veiculoAtualizado.getModelo());
                    veiculo.setNumeroIdentificacao(veiculoAtualizado.getNumeroIdentificacao());
                    return veiculoRepository.save(veiculo);
                })
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }
}