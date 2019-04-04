package br.com.saulo.anp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@EqualsAndHashCode(of = { "regiao" }, callSuper = false)
@ToString(of = { "regiao" })
public class HistoricoCombustivelRegiaoEntidade implements Serializable {
	
	
    private static final long serialVersionUID = -5633260910164953251L;

    @Id
    @Column(name = "REGIAO")
    private String regiao;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGIAO", referencedColumnName = "REGIAO", insertable= false, updatable= false)
    private List<HistoricoCombustivelEntidade> detalhe;
    

}
