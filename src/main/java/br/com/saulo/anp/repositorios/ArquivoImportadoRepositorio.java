package br.com.saulo.anp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.anp.entidades.ArquivoImportadoEntidade;

@Repository
public interface ArquivoImportadoRepositorio extends JpaRepository<ArquivoImportadoEntidade, Long> {

	ArquivoImportadoEntidade findById(long id);

	boolean existsByNome(String nome);
	

}
