package hack.api.com.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Dono;

@Transactional
@Repository
public interface DonoRepositorio extends JpaRepository<Dono, Long>{

}
