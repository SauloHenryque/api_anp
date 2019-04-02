package br.com.saulo.anp.validation;

public enum ImportacaoArquivoEnum {
	
	ARQUIVO_DUPLICADO(new AnaliseImportacaoArquivoDuplicado());
	
	private AnaliseImportacaoArquivo regra;
	
	ImportacaoArquivoEnum(AnaliseImportacaoArquivo regra){
		this.regra = regra;
	}
	
	public AnaliseImportacaoArquivo getRegra() {
		return regra;
	}

}
