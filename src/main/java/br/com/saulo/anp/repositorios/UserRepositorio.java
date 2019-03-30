package br.com.saulo.anp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.anp.entidades.UserEntidade;

@Repository
public interface UserRepositorio extends JpaRepository<UserEntidade, Long> {

	UserEntidade findById(long id);

	boolean existsByEmail(String email);

	boolean existsByEmailAndIdNotIn(String email, Long id);
	

}
