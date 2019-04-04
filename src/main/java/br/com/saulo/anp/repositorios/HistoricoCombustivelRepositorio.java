package br.com.saulo.anp.repositorios;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;

@Repository
public interface HistoricoCombustivelRepositorio extends JpaRepository<HistoricoCombustivelEntidade, Long> {

	HistoricoCombustivelEntidade findById(long id);
	
	@Query(value = "SELECT municipio,  AVG(VALOR_VENDA) AS media_venda FROM HISTORICO_COMBUSTIVEL  GROUP BY MUNICIPIO", nativeQuery = true)
	List<Map<String, String>> findByAVGValorVenda();
	
}
