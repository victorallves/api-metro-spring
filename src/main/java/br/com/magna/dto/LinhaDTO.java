package br.com.magna.dto;

public class LinhaDTO {
	private Long idLinha;
	private String nome;
	private String tipoTransporte;
	private String estacaoInicio;
	private String estacaoFim;

	public LinhaDTO (){}
	
	public LinhaDTO(Long idLinha, String nome, String tipoTransporte, String estacaoInicio, String estacaoFim) {
		super();
		this.idLinha = idLinha;
		this.nome = nome;
		this.tipoTransporte = tipoTransporte;
		this.estacaoInicio = estacaoInicio;
		this.estacaoFim = estacaoFim;
	}



	public Long getidLinha() {
		return idLinha;
	}

	public void setIdidLinha(Long idLinha) {
		this.idLinha = idLinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getEstacaoInicio() {
		return estacaoInicio;
	}

	public void setEstacaoInicio(String estacaoInicio) {
		this.estacaoInicio = estacaoInicio;
	}

	public String getEstacaoFim() {
		return estacaoFim;
	}

	public void setEstacaoFim(String estacaoFim) {
		this.estacaoFim = estacaoFim;
	}
	
	
}