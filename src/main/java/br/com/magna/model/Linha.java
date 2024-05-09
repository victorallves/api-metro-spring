package br.com.magna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Linha")
public class Linha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linha")
    private Long idLinha;

    @Column(name = "nome")//(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_transporte")//(name = "tipo_transporte", nullable = false)
    private String tipoTransporte;

    @Column(name = "estacao_inicio")//(name = "estacao_inicio", nullable = false)
    private String estacaoInicio;

    @Column(name = "estacao_fim") //(name = "estacao_fim", nullable = false) 
    private String estacaoFim;

	public Long getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(Long idLinha) {
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