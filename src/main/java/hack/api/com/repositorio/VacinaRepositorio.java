package hack.api.com.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Dono;
import hack.api.com.modelo.Vacina;

@Transactional
@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina,Long>{
	@Query("SELECT vcn  FROM Vacina vcn WHERE vcn.nome like %?1%")
	List<Vacina> findAllByName(String param);
}
