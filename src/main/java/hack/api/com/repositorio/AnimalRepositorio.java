package hack.api.com.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Animal;


@Repository
public interface AnimalRepositorio extends JpaRepository<Animal,Long>{

	
	  @Query("SELECT animal FROM Animal animal WHERE animal.nome like %?1%")
	  List<Animal>  findAllByName(String param);
	 
		
	 
}
