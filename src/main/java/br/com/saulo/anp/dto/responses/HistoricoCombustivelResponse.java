package br.com.saulo.anp.dto.responses;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Historico Combustivel")
public class HistoricoCombustivelResponse implements Serializable{

	private static final long serialVersionUID = 8192610937139207457L;
	
    @ApiModelProperty(value = "Identificação Historico Combustivel", position = 1)
    private Long id;

    @ApiModelProperty(value = "Região", position = 2)
    private String regiao;
    
    @ApiModelProperty(value = "Estado", position = 3)
    private String estado;
    
    @ApiModelProperty(value = "Municipio", position = 4)
    private String municipio;
    
    @ApiModelProperty(value = "revenda", position = 5)
    private String revenda;
    
    @ApiModelProperty(value = "Instalação", position = 6)
    private String instalacao;
    
    @ApiModelProperty(value = "Produto", position = 7)
    private String produto;
    
    @ApiModelProperty(value = "Data Coleta", position = 8)
    private LocalDate data_coleta;
    
    @ApiModelProperty(value = "Valor Compra", position = 9)
    private BigDecimal valor_compra;
    
    @ApiModelProperty(value = "Valor Venda", position = 10)
    private BigDecimal valor_venda;
    
    @ApiModelProperty(value = "Unidade", position = 11)
    private String unidade;
    
    @ApiModelProperty(value = "Bandeira", position = 12)
    private String bandeira;
}
