package br.com.saulo.anp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.anp.entidades.HistoricoCombustivelRegiaoEntidade;

@Repository
public interface HistoricoCombustivelRegiaoRepositorio extends JpaRepository<HistoricoCombustivelRegiaoEntidade, Long> {
	
}
