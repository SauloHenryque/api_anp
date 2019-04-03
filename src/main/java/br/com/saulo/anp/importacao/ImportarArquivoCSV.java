package br.com.saulo.anp.importacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.dto.persists.HistoricoCombustivelPersist;
import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.ultil.InvokeMetodoClasse;

public class ImportarArquivoCSV implements ImportarArquivo{

	@Override
	public List<HistoricoCombustivelEntidade> lerArquivo(MultipartFile files){
		
//		String listaHeader[] = {"Região - Sigla",  "Estado - Sigla", "Município", "Revenda", "Instalação - Código", "Produto", "Data da Coleta", "Valor de Compra", ""};
		
		Map<String,String> mapeamentos = this.mapeamentoArquivo();
		List<HistoricoCombustivelEntidade> listaHistoricoCombustivel = null;
		InputStream inputStream;
		
		try {
			inputStream = files.getInputStream();
			BufferedReader bufferReader;
			bufferReader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
			Iterable<CSVRecord> records;
			records = CSVFormat.DEFAULT.withDelimiter(delimiter).withFirstRecordAsHeader().parse(bufferReader);
			
			for (CSVRecord record:records) {
				
				for (String header : mapeamentos.keySet() ) {
				
					if (record.isMapped(mapeamentos.get(header))) {
						String produto= record.get(mapeamentos.get(header));
//				 	String valor= record.get("valor");
					}
				}
			 	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaHistoricoCombustivel;
		
	}
	
	private Map<String,String> mapeamentoArquivo () {
		
		Map<String,String> mapeamento = new HashMap<String,String>();
		
        for (Field atributos : HistoricoCombustivelPersist.class.getDeclaredFields()) {
        
        	try {
        		
        		mapeamento.put( atributos.getName(), InvokeMetodoClasse.retornarValorMetodo(atributos.getName()));
        		
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
            
        }

		return mapeamento;
	
	}

}
