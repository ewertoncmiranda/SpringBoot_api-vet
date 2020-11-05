package hack.api.com.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Animal;

@Transactional
@Repository
public interface AnimalRepositorio extends JpaRepository<Animal,Long>{


}
