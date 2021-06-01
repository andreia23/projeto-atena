package br.edu.ifpb.pweb2.atena.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.atena.business.model.UsuarioAdmin;

@Repository
public interface UsuarioAdminRepository extends JpaRepository<UsuarioAdmin, Integer> {
	
//	@Query("select c from Cliente c where c.cpf = ?1")
	
	@Query("select u from UsuarioAdmin u where u.nome = ?1")
	public UsuarioAdmin findByName(String name);

}
