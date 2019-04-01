package br.com.saulo.anp.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.dto.persists.UserPersist;
import br.com.saulo.anp.dto.request.UserRequest;
import br.com.saulo.anp.dto.responses.UserResponse;
import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.servicos.UserServico;
import br.com.saulo.anp.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "usuario")
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {
	
	 	@Autowired
		private UserServico userServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid UserPersist request) {

			UserEntidade userEntidade   = GenericConvert.convertModelMapper(request, UserEntidade.class);
			userEntidade 				= userServico.salvarUser(userEntidade);
			UserResponse response 		= GenericConvert.convertModelMapper(userEntidade, UserResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid UserPersist request ) {
			
			UserEntidade userEntidade 	= GenericConvert.convertModelMapper(request, UserEntidade.class);
			userEntidade.setId(id);
			
			userEntidade 				= userServico.atualizarUser(userEntidade);
			UserResponse response 		= GenericConvert.convertModelMapper(userEntidade, UserResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

		@GetMapping
	    public ResponseEntity<?> listar(@Valid UserRequest lojaRequest) {
			
			UserEntidade userEntidade = GenericConvert.convertModelMapper(lojaRequest, UserEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(userServico.listarUser(userEntidade));
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
			userServico.deletarUser(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }
		
		@PostMapping("/importar-arquivo")
		public String importarArquivo (@RequestPart("arquivo_excel") MultipartFile files) throws IOException {
			
			InputStream teste = files.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(teste, "UTF8")); 
			Iterable<CSVRecord> parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(br);
			
			 for (CSVRecord record:parser) {
				 	String produto= record.get("produto");
				 	String valor= record.get("valor");
		     }

			return null;
			
		}

}
