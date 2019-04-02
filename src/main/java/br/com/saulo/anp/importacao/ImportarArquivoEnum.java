package br.com.saulo.anp.importacao;

public enum ImportarArquivoEnum {

	CSV(new ImportarArquivoCSV());
	
	private ImportarArquivo tipoArquivo;
	
	ImportarArquivoEnum(ImportarArquivo arquivo) {
		
		this.tipoArquivo = arquivo;
	}
	
	public ImportarArquivo getTipoArquivo() {
		
		return this.tipoArquivo;
	}
}
