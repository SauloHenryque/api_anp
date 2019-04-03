package br.com.saulo.anp.servicos;

import static br.com.saulo.anp.exception.Exceptions.checkThrow;
import static br.com.saulo.anp.exception.ExceptionsMessagesEnum.EMAIL_JA_CADASTRADO;
import static br.com.saulo.anp.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.repositorios.UserRepositorio;
import lombok.Data;

@Data
@Service
public class UserServico {
	
    
    @Autowired
    private UserRepositorio userRepositorio;

	public UserEntidade salvarUser(UserEntidade userEntidade) {
		
		checkThrow(userRepositorio.existsByEmail(userEntidade.getEmail()), EMAIL_JA_CADASTRADO);
        return userRepositorio.save(userEntidade);

	}
	
	public UserEntidade atualizarUser(UserEntidade userEntidade) {
		
		checkThrow(!userRepositorio.existsById(userEntidade.getId()), REGISTRO_NAO_ENCONTRADO);
		checkThrow(userRepositorio.existsByEmailAndIdNotIn(userEntidade.getNome(), userEntidade.getId()), EMAIL_JA_CADASTRADO);
		 
		return userRepositorio.save(userEntidade);
	}
	
    public List<UserEntidade> listarUser(UserEntidade userEntidade) {

    	return userRepositorio.findAll(Example.of(userEntidade));

    }
	
    public void deletarUser(long id) {
    	
		checkThrow(!userRepositorio.existsById(id), REGISTRO_NAO_ENCONTRADO);
		UserEntidade storeEntidade = userRepositorio.findById(id);
		userRepositorio.delete(storeEntidade);
    }


}
