package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Linha;

	@Repository
	public interface LinhaRepository extends JpaRepository<Linha, Long> {
		
	}