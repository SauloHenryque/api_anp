package br.com.saulo.anp.importacao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;

public interface ImportarArquivo {
	
	char delimiter = ';'; 
	
	public List<HistoricoCombustivelEntidade> lerArquivo(MultipartFile files);

}
