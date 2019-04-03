package br.com.saulo.anp.servicos;

import static br.com.saulo.anp.exception.Exceptions.checkThrow;
import static br.com.saulo.anp.exception.ExceptionsMessagesEnum.NOME_JA_CADASTRADO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.anp.entidades.ArquivoImportadoEntidade;
import br.com.saulo.anp.repositorios.ArquivoImportadoRepositorio;
import lombok.Data;

@Data
@Service
public class ArquivoImportadoServico {
	
    
    @Autowired
    private ArquivoImportadoRepositorio arquivoImportadoRepositorio;

	public ArquivoImportadoEntidade salvarArquivo(ArquivoImportadoEntidade arquivoImportadoEntidade) {
		
//		checkThrow(arquivoImportadoRepositorio.existsByNome(arquivoImportadoEntidade.getNome()), NOME_JA_CADASTRADO);
        return arquivoImportadoRepositorio.save(arquivoImportadoEntidade);

	}
}
