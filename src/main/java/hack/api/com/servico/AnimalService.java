package hack.api.com.servico;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.repositorio.AnimalRepositorio;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepositorio repo ;
	
	@Transactional(readOnly=true)
	public List<AnimalDTO> findall(){
		List<Animal> lista = repo.findAll();
		return lista.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());
	}	
	
	@Transactional
	public List<AnimalDTO> saveAll(List<Animal> lista){
	 Iterable<Animal> it = lista ; 
	 List<Animal> dto = repo.saveAll(it);
	 return dto.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public AnimalDTO save(Animal animal) {
		return new AnimalDTO(repo.save(animal));
	}
	

}
