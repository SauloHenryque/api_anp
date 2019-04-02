package br.com.saulo.anp.importacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;

public class ImportarArquivoCSV implements ImportarArquivo{

	@Override
	public List<HistoricoCombustivelEntidade> lerArquivo(MultipartFile files){
		
//		String listaHeader[] = {"Região - Sigla",  "Estado - Sigla", "Município", "Revenda", "Instalação - Código", "Produto", "Data da Coleta", "Valor de Compra", ""};
		
		List<HistoricoCombustivelEntidade> listaHistoricoCombustivel = null;
		InputStream inputStream;
		
		try {
			inputStream = files.getInputStream();
			BufferedReader bufferReader;
			bufferReader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
			Iterable<CSVRecord> records;
			records = CSVFormat.DEFAULT.withDelimiter(delimiter).withFirstRecordAsHeader().parse(bufferReader);
			
			for (CSVRecord record:records) {
			 	String produto= record.get("produto");
			 	String valor= record.get("valor");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaHistoricoCombustivel;
		
	}

}
