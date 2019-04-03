package br.com.saulo.anp.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.importacao.ImportarArquivoCSV;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRepositorio;
import lombok.Data;

@Data
@Service
public class HistoricoCombustivelServico {
	
    
    @Autowired
    private HistoricoCombustivelRepositorio historicoCombustivelRepositorio;

	public HistoricoCombustivelEntidade salvarHistoricoCombustivel(HistoricoCombustivelEntidade historicoCombustivelEntidade) {
		
//		checkThrow(historicoCombustivelRepositorio.existsByEmail(userEntidade.getEmail()), EMAIL_JA_CADASTRADO);
        return historicoCombustivelRepositorio.save(historicoCombustivelEntidade);

	}
	
	public HistoricoCombustivelEntidade atualizarHistoricoCombustivel(HistoricoCombustivelEntidade historicoCombustivelEntidade) {
		
//		checkThrow(!userRepositorio.existsById(userEntidade.getId()), REGISTRO_NAO_ENCONTRADO);
//		checkThrow(userRepositorio.existsByEmailAndIdNotIn(userEntidade.getNome(), userEntidade.getId()), EMAIL_JA_CADASTRADO);
		 
		return historicoCombustivelRepositorio.save(historicoCombustivelEntidade);
	}
	
    public List<HistoricoCombustivelEntidade> listarHistoricoCombustivel(HistoricoCombustivelEntidade historicoCombustivelEntidade) {

    	return historicoCombustivelRepositorio.findAll(Example.of(historicoCombustivelEntidade));

    }
	
    public void deletarHistoricoCombustivel(long id) {
    	
//		checkThrow(!historicoCombustivelRepositorio.existsById(id), REGISTRO_NAO_ENCONTRADO);
//    	HistoricoCombustivelEntidade historicoCombustivelEntidade = historicoCombustivelRepositorio.findById(id);
//    	historicoCombustivelRepositorio.delete(historicoCombustivelEntidade);
    }
    
    
    @SuppressWarnings("null")
	public List<HistoricoCombustivelEntidade> importarArquivoHistoricoCombustivel (MultipartFile files) {
    	
    	List<HistoricoCombustivelEntidade> result = null;
    	ImportarArquivoCSV importarArquivo  = new ImportarArquivoCSV();
    	List<HistoricoCombustivelEntidade> listHistoricoCombustivel = importarArquivo.lerArquivo(files);
    	
    	for (HistoricoCombustivelEntidade historicoCombustivel : listHistoricoCombustivel) {
    		
    			result.add(historicoCombustivelRepositorio.save(historicoCombustivel));
    	}
    	
    	return result;
    	
    }


}
