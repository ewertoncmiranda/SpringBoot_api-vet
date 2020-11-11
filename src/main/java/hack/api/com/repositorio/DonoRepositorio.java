package hack.api.com.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Dono;

@Transactional
@Repository
public interface DonoRepositorio extends JpaRepository<Dono, Long>{

	/*
	 * @Query("SELECT dono FROM dono Dono WHERE dono.nome like %?1%") List<Dono>
	 * findAllByName(String param);
	 */
	
	/* @Query("SELECT dono FROM Dono dono JOIN FETCH dono.listaDeAnimais") */		 
	
}
