package br.com.magna.dto;

public class VeiculoDTO {
	private Long idVeiculo;
	private String tipo;
	private String modelo;
	private String numeroIdentificacao;

	public VeiculoDTO (){}

	public VeiculoDTO(Long idVeiculo, String tipo, String modelo, String numeroIdentificacao) {
		super();
		this.idVeiculo = idVeiculo;
		this.tipo = tipo;
		this.modelo = modelo;
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}
	
	
	
}