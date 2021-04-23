package hack.api.com.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.user.UsuarioSistema;

@Repository
public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Long>{
	
	Optional<UsuarioSistema> findByNome(String nome);

}
