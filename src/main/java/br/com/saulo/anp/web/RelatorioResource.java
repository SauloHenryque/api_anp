package br.com.saulo.anp.web;

import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.anp.dto.persists.UserPersist;
import br.com.saulo.anp.dto.request.UserRequest;
import br.com.saulo.anp.dto.responses.UserResponse;
import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.servicos.RelatorioServico;
import br.com.saulo.anp.ultil.ConversorGenerico;
import br.com.saulo.anp.ultil.InvokeMetodoClasse;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "relatorio")
@RequestMapping(value = "/api/relatorio", produces = MediaType.APPLICATION_JSON_VALUE)
public class RelatorioResource {
	
	 	@Autowired
		private RelatorioServico relatorioServico;

//		@GetMapping("/")
//	    public ResponseEntity<?> listar(@Valid UserRequest lojaRequest) {
//			
//			UserEntidade userEntidade = ConversorGenerico.convertModelMapper(lojaRequest, UserEntidade.class);	
//			return ResponseEntity.status(HttpStatus.OK).body(userServico.listarUser(userEntidade));
//	    }
//		
//		@DeleteMapping("/{id}")
//	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
//			userServico.deletarUser(id);
//	        return ResponseEntity.ok(HttpStatus.OK);
//	    }

}
