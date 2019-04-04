package br.com.saulo.anp.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.saulo.anp.entidades.HistoricoCombustivelRegiaoEntidade;

@Repository
public interface HistoricoCombustivelRegiaoRepositorio extends JpaRepository<HistoricoCombustivelRegiaoEntidade, Long> {

	@Query(value = "SELECT REGIAO FROM HISTORICO_COMBUSTIVEL  GROUP BY REGIAO", nativeQuery = true)
	List<HistoricoCombustivelRegiaoEntidade> findAllByRegiao();
	
}
