package br.com.magna.model;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")//(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cargo")//(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "salario") //(name = "salario", nullable = false)
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "linha_id")
    private Linha linha;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

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

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

    

}