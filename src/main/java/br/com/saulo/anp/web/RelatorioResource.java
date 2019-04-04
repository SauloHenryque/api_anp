package br.com.saulo.anp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.anp.servicos.RelatorioServico;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "relatorio")
@RequestMapping(value = "/api/relatorio", produces = MediaType.APPLICATION_JSON_VALUE)
public class RelatorioResource {
	
	 	@Autowired
		private RelatorioServico relatorioServico;

		@GetMapping("/media-preco-combustivel")
	    public ResponseEntity<?> mediaPrecoCombustivel() {
			
			return ResponseEntity.status(HttpStatus.OK).body(relatorioServico.mediaPrecoCombustivel());
	    }
		
		@GetMapping("/detalhe-por-regiao")
		public ResponseEntity<?> detalhePorRegiao() {
			return ResponseEntity.status(HttpStatus.OK).body(relatorioServico.detalhePorRegiao());
		}

		@GetMapping("/detalhe-por-destribuidora")
		public ResponseEntity<?> detalhePorRevenda() {
			return ResponseEntity.status(HttpStatus.OK).body(relatorioServico.detalhePorRevenda());
		}
		


}
