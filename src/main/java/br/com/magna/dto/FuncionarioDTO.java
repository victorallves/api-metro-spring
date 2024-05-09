package br.com.magna.dto;

public class FuncionarioDTO {
	private Long id;
	private String nome;
	private String cargo;
	private Double salario;
	private LinhaDTO linha;
	private VeiculoDTO veiculo;

	public FuncionarioDTO (){}
	
	public FuncionarioDTO(Long id, String nome, String cargo, Double salario, LinhaDTO linha, VeiculoDTO veiculo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.linha = linha;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LinhaDTO getLinha() {
		return linha;
	}

	public void setLinha(LinhaDTO linha) {
		this.linha = linha;
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

}