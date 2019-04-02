package br.com.saulo.anp.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Table(name = "HISTORICO_COMBUSTIVEL")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class HistoricoCombustivelEntidade implements Serializable {
	
	
    private static final long serialVersionUID = -5633260910164953251L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "REGIAO")
    private String regiao;

    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "MUNICIPIO")
    private String municipio;
    
    @Column(name = "REVENDA")
    private String revenda;
    
    @Column(name = "INSTALACAO")
    private String instalacao;
    
    @Column(name = "PRODUTO")
    private String produto;
    
    @Column(name = "DATA_COLETA")
    private LocalDate data_coleta;
    
    @Column(name = "VALOR_COMPRA")
    private BigDecimal valor_compra;
    
    @Column(name = "VALOR_VENDA")
    private BigDecimal valor_venda;
    
    @Column(name = "UNIDADE")
    private String unidade;
    
    @Column(name = "BANDEIRA")
    private String bandeira;
    

}
