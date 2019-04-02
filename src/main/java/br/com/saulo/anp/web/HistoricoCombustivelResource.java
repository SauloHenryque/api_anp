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
import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.servicos.HistoricoCombustivelServico;
import br.com.saulo.anp.servicos.UserServico;
import br.com.saulo.anp.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "historico")
@RequestMapping(value = "/api/historico-combustivel", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoricoCombustivelResource {
	
	 	@Autowired
		private HistoricoCombustivelServico historicoCombustivelServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid HistoricoCombustivelPersist request) {

			HistoricoCombustivelEntidade historicoCombustivelEntidade   = GenericConvert.convertModelMapper(request, HistoricoCombustivelEntidade.class);
			historicoCombustivelEntidade 								= historicoCombustivelServico.salvarHistoricoCombustivel(historicoCombustivelEntidade);
			HistoricoCombustivelResponse response 						= GenericConvert.convertModelMapper(historicoCombustivelEntidade, HistoricoCombustivelResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid HistoricoCombustivelPersist request ) {
			
			HistoricoCombustivelEntidade historicoCombustivelEntidade 	= GenericConvert.convertModelMapper(request, HistoricoCombustivelEntidade.class);
			historicoCombustivelEntidade.setId(id);
			
			historicoCombustivelEntidade 				= historicoCombustivelServico.atualizarHistoricoCombustivel(historicoCombustivelEntidade);
			HistoricoCombustivelResponse response 		= GenericConvert.convertModelMapper(historicoCombustivelEntidade, HistoricoCombustivelResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

		@GetMapping
	    public ResponseEntity<?> listar(@Valid HistoricoCombustivelRequest historicoCombustivelRequest) {
			
			HistoricoCombustivelEntidade historicoCombustivelEntidade = GenericConvert.convertModelMapper(lojaRequest, UserEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(historicoCombustivelServico.listarHistoricoCombustivel(historicoCombustivelEntidade));
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
			historicoCombustivelServico.deletarHistoricoCombustivel(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }
		
		@PostMapping("/importar-arquivo")
		public ResponseEntity<?> importarArquivo (@RequestPart("arquivo_excel") MultipartFile files) {

			historicoCombustivelServico.importarHistoricoCombustivel(files);
			
			return ResponseEntity.ok(HttpStatus.OK);
			
		}

}
