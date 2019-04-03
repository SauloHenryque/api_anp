package br.com.saulo.anp.web;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.dto.persists.HistoricoCombustivelPersist;
import br.com.saulo.anp.dto.request.HistoricoCombustivelRequest;
import br.com.saulo.anp.dto.responses.HistoricoCombustivelResponse;
import br.com.saulo.anp.entidades.ArquivoImportadoEntidade;
import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.servicos.ArquivoImportadoServico;
import br.com.saulo.anp.servicos.HistoricoCombustivelServico;
import br.com.saulo.anp.ultil.ConversorGenerico;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "historico")
@RequestMapping(value = "/api/historico-combustivel", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoricoCombustivelResource {
	
	 	@Autowired
		private HistoricoCombustivelServico historicoCombustivelServico;
		
	 	@Autowired
		private ArquivoImportadoServico arquivoImportadoServico;
	 	
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid HistoricoCombustivelPersist request) {

			HistoricoCombustivelEntidade historicoCombustivelEntidade   = ConversorGenerico.convertModelMapper(request, HistoricoCombustivelEntidade.class);
			historicoCombustivelEntidade 								= historicoCombustivelServico.salvarHistoricoCombustivel(historicoCombustivelEntidade);
			HistoricoCombustivelResponse response 						= ConversorGenerico.convertModelMapper(historicoCombustivelEntidade, HistoricoCombustivelResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid HistoricoCombustivelPersist request ) {
			
			HistoricoCombustivelEntidade historicoCombustivelEntidade 	= ConversorGenerico.convertModelMapper(request, HistoricoCombustivelEntidade.class);
			historicoCombustivelEntidade.setId(id);
			
			historicoCombustivelEntidade 				= historicoCombustivelServico.atualizarHistoricoCombustivel(historicoCombustivelEntidade);
			HistoricoCombustivelResponse response 		= ConversorGenerico.convertModelMapper(historicoCombustivelEntidade, HistoricoCombustivelResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

		@GetMapping
	    public ResponseEntity<?> listar(@Valid HistoricoCombustivelRequest historicoCombustivelRequest) {
			
			HistoricoCombustivelEntidade historicoCombustivelEntidade = ConversorGenerico.convertModelMapper(historicoCombustivelRequest, HistoricoCombustivelEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(historicoCombustivelServico.listarHistoricoCombustivel(historicoCombustivelEntidade));
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
			historicoCombustivelServico.deletarHistoricoCombustivel(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }
		
		@PostMapping("/importar-arquivo")
		public ResponseEntity<?> importarArquivo (@RequestPart("arquivo_excel") MultipartFile files) {

			ArquivoImportadoEntidade arquivoImportadoEntidade = new ArquivoImportadoEntidade();
			arquivoImportadoEntidade.setNome(files.getOriginalFilename());
			arquivoImportadoServico.salvarArquivo(arquivoImportadoEntidade);
			
			
			historicoCombustivelServico.importarArquivoHistoricoCombustivel(files);
			return ResponseEntity.ok(HttpStatus.OK);
			
		}

}
