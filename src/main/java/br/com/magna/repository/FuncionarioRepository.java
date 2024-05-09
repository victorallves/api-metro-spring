package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Funcionario;

	@Repository
	public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
		
	}
