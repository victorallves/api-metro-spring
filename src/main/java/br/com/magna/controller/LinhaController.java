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

import br.com.magna.model.Linha;
import br.com.magna.repository.LinhaRepository;

@RestController
@RequestMapping("/linhas")
public class LinhaController {
    @Autowired
    private LinhaRepository linhaRepository;

    @GetMapping
    public List<Linha> getAllLinhas() {
        return linhaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Linha getLinhaById(@PathVariable Long id) {
        return linhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Linha não encontrada com ID: " + id));
    }

    @PostMapping
    public Linha addLinha(@RequestBody Linha linha) {
        return linhaRepository.save(linha);
    }

    @PutMapping("/{id}")
    public Linha updateLinha(@PathVariable Long id, @RequestBody Linha linhaAtualizada) {
        return linhaRepository.findById(id)
                .map(linha -> {
                    linha.setNome(linhaAtualizada.getNome());
                    linha.setTipoTransporte(linhaAtualizada.getTipoTransporte());
                    linha.setEstacaoInicio(linhaAtualizada.getEstacaoInicio());
                    linha.setEstacaoFim(linhaAtualizada.getEstacaoFim());
                    return linhaRepository.save(linha);
                })
                .orElseThrow(() -> new RuntimeException("Linha não encontrada com ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteLinha(@PathVariable Long id) {
        linhaRepository.deleteById(id);
    }
}