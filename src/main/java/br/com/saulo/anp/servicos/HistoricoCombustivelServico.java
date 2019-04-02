package br.com.saulo.anp.servicos;

import static br.com.saulo.anp.exception.ExceptionOrder.checkThrow;
import static br.com.saulo.anp.exception.ExceptionsMessagesEnum.EMAIL_JA_CADASTRADO;
import static br.com.saulo.anp.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRepositorio;
import br.com.saulo.anp.repositorios.UserRepositorio;
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
    	HistoricoCombustivelEntidade historicoCombustivelEntidade = historicoCombustivelRepositorio.findById(id);
    	historicoCombustivelRepositorio.delete(historicoCombustivelEntidade);
    }


}
