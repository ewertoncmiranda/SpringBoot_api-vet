package miranda.cordeiro.vet.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miranda.cordeiro.vet.entity.Vacina;

@Repository
@Transactional
public interface VacinaRepository extends JpaRepository<Vacina, Long>{

}
