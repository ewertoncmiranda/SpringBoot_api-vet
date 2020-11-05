package hack.api.com.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hack.api.com.modelo.Vacina;

@Transactional
@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina,Long>{

}
