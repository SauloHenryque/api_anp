package br.com.saulo.anp.servicos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.anp.entidades.HistoricoCombustivelRegiaoEntidade;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRegiaoRepositorio;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRepositorio;
import lombok.Data;

@Data
@Service
public class RelatorioServico {
	
    
    @Autowired
    private HistoricoCombustivelRepositorio historicoCombustivelRepositorio;
    
    @Autowired
    private HistoricoCombustivelRegiaoRepositorio historicoCombustivelRegiaoRepositorio;

	public List<Map<String, String>> mediaPrecoCombustivel() {
		
		return historicoCombustivelRepositorio.findByAVGValorVenda();
	}
	
	
	public List<HistoricoCombustivelRegiaoEntidade> detalhePorRegiao() {
		
		return historicoCombustivelRegiaoRepositorio.findAll();
	}
}
