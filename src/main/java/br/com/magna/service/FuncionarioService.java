package br.com.magna.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.dto.FuncionarioDTO;
import br.com.magna.dto.LinhaDTO;
import br.com.magna.dto.VeiculoDTO;
import br.com.magna.model.Funcionario;
import br.com.magna.model.Linha;
import br.com.magna.model.Veiculo;
import br.com.magna.repository.FuncionarioRepository;
import br.com.magna.repository.LinhaRepository;
import br.com.magna.repository.VeiculoRepository;

@Service
public class FuncionarioService {

	private final LinhaRepository linhaRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final VeiculoRepository veiculoRepository;

	@Autowired
	public FuncionarioService(LinhaRepository linhaRepository, FuncionarioRepository funcionarioRepository,
			VeiculoRepository veiculoRepository) {
		this.linhaRepository = linhaRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.veiculoRepository = veiculoRepository;
	}

	public void cadastrarFuncionarioComLinhaEVeiculo(FuncionarioDTO funcionarioDTO) {
		Linha linha = criarLinhaAPartirDoDTO(funcionarioDTO.getLinha());
		Veiculo veiculo = criarVeiculoAPartirDoDTO(funcionarioDTO.getVeiculo());

		veiculoRepository.save(veiculo);
		Funcionario funcionario = criarFuncionarioAPartirDoDTO(funcionarioDTO);

		funcionario.setVeiculo(veiculo);
		funcionario.setLinha(linha);
		linhaRepository.save(linha);
		funcionarioRepository.save(funcionario);
	}

	private Linha criarLinhaAPartirDoDTO(LinhaDTO linhaDTO) {
		Linha linha = new Linha();
		linha.setNome(linhaDTO.getNome());
		linha.setTipoTransporte(linhaDTO.getTipoTransporte());
		linha.setEstacaoInicio(linhaDTO.getEstacaoInicio());
		linha.setEstacaoFim(linhaDTO.getEstacaoFim());
		return linha;
	}

	private Funcionario criarFuncionarioAPartirDoDTO(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setCargo(funcionarioDTO.getCargo());
		funcionario.setSalario(funcionarioDTO.getSalario());
		return funcionario;
	}

	private Veiculo criarVeiculoAPartirDoDTO(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipo(veiculoDTO.getTipo());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setNumeroIdentificacao(veiculoDTO.getNumeroIdentificacao());
		return veiculo;
	}

	public List<FuncionarioDTO> getAllFuncionariosComDetalhes() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return funcionarios.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	private FuncionarioDTO mapToDTO(Funcionario funcionario) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setId(funcionario.getId());
		dto.setNome(funcionario.getNome());
		dto.setCargo(funcionario.getCargo());
		dto.setSalario(funcionario.getSalario());
		dto.setLinha(mapLinhaToDTO(funcionario.getLinha()));
		dto.setVeiculo(mapVeiculoToDTO(funcionario.getVeiculo()));
		return dto;
	}

	private LinhaDTO mapLinhaToDTO(Linha linha) {
		if (linha == null) {
			return null;
		}
		LinhaDTO dto = new LinhaDTO();
		dto.setIdidLinha(linha.getIdLinha());
		dto.setNome(linha.getNome());
		dto.setTipoTransporte(linha.getTipoTransporte());
		dto.setEstacaoInicio(linha.getEstacaoInicio());
		dto.setEstacaoFim(linha.getEstacaoFim());
		return dto;
	}

	private VeiculoDTO mapVeiculoToDTO(Veiculo veiculo) {
		if (veiculo == null) {
			return null;
		}
		VeiculoDTO dto = new VeiculoDTO();
		dto.setIdVeiculo(veiculo.getIdVeiculo());
		dto.setTipo(veiculo.getTipo());
		dto.setModelo(veiculo.getModelo());
		dto.setNumeroIdentificacao(veiculo.getNumeroIdentificacao());
		return dto;
	}
}
