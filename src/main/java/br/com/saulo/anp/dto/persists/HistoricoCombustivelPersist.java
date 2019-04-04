package br.com.saulo.anp.dto.persists;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Historico Combustivel Persist")
public class HistoricoCombustivelPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
    @ApiModelProperty(value = "Região", position = 1)
    @NotNull(message = "Regiao não pode ser nulo")
    private String regiao;
    
    @ApiModelProperty(value = "Estado", position = 2)
    @NotNull(message = "Estado não pode ser nulo")
    private String estado;
    
    @ApiModelProperty(value = "Municipio", position = 3)
    @NotNull(message = "Municipio não pode ser nulo")
    private String municipio;
    
    @ApiModelProperty(value = "revenda", position = 4)
    @NotNull(message = "Revenda não pode ser nulo")
    private String revenda;
    
    @ApiModelProperty(value = "Instalação", position = 5)
    @NotNull(message = "Instalação não pode ser nulo")
    private String instalacao;
    
    @ApiModelProperty(value = "Produto", position = 6)
    @NotNull(message = "Produto não pode ser nulo")
    private String produto;
    
    @ApiModelProperty(value = "Data Coleta", position = 7)
    @NotNull(message = "Data Coleta não pode ser nulo")
    private LocalDate data_coleta;
    
    @ApiModelProperty(value = "Valor Compra", position = 8)
    private BigDecimal valor_compra;
    
    @ApiModelProperty(value = "Valor Venda", position = 9)
    private BigDecimal valor_venda;
    
    @ApiModelProperty(value = "Unidade", position = 10)
    @NotNull(message = "Unidadeo não pode ser nulo")
    private String unidade;
    
    @ApiModelProperty(value = "Bandeira", position = 11)
    @NotNull(message = "Bandeira não pode ser nulo")
    private String bandeira;
    
    

}
