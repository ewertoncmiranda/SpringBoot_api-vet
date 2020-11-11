package hack.api.com.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.modelo.interfaces.MeuCrud;
import hack.api.com.repositorio.AnimalRepositorio;

@Service
public class AnimalService implements MeuCrud<AnimalDTO, Animal> {

	@Autowired
	AnimalRepositorio repo;

	@Transactional(readOnly = true)
	public List<AnimalDTO> findAll() {
		List<Animal> lista = repo.findAll();
		return lista.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());
	}

	@Transactional
	public List<AnimalDTO> saveAll(List<Animal> lista) {
		Iterable<Animal> it = lista;
		List<Animal> dto = repo.saveAll(it);
		return dto.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());

	}

	@Transactional
	public AnimalDTO save(Animal animal) {
		return new AnimalDTO(repo.save(animal));
	}

	@Override
	public AnimalDTO edit(Animal animal) {
		Animal s = null ;
		if(repo.existsById(animal.getAnimal_id())) {
		 s = repo.save(animal);  
	  }		
		return new AnimalDTO(s);
	}

	@Override
	public void delete(Long id) {
		if (repo.existsById(id)) {
			repo.delete(repo.findById(id).get());
		} else {
			System.out.println("---------ANIMAL NÃO EXISTE---------");
		}
	}

	@Override
	public AnimalDTO findById(Long id) {
	return new AnimalDTO(repo.findById(id).get());
	}

	@Override
	public List<AnimalDTO> findAllByName(String nome) {
		List<Animal> dto = repo.findAllByName(nome);
		return dto.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());

	}

}
