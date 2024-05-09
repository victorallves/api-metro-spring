package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Veiculo;

	@Repository
	public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
		
	}