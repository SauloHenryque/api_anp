package br.com.saulo.anp.importacao;

import lombok.Data;

@Data
public class ArquivoCSV {
	
    private String regiao  		= "Regiao - Sigla";
    
    private String estado		= "Estado - Sigla";
    
    private String municipio 	= "Municipio";
   
    private String revenda		= "Revenda";
    
    private String instalacao	= "Instalacao - Codigo";
    
    private String produto		= "Produto";
    
    private String data_coleta	= "Data da Coleta";
    
    private String valor_compra	= "Valor de Compra";
    
    private String valor_venda	= "Valor de Venda";
    
    private String unidade		= "Unidade de Medida";
    
    private String bandeira		= "Bandeira";

}
