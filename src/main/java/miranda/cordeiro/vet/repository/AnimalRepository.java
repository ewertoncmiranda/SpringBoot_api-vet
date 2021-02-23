package miranda.cordeiro.vet.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miranda.cordeiro.vet.entity.Animal;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
