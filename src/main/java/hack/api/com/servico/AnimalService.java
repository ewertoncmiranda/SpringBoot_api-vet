package hack.api.com.servico;



import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.repositorio.AnimalRepositorio;
import hack.api.com.repositorio.VacinaRepositorio;

@Service
public class AnimalService {

	@Autowired
	AnimalRepositorio repo;
	
	@Autowired
	VacinaRepositorio repoVacina;
	
	ModelMapper map = new ModelMapper();
	
	public List<AnimalDTO> findAll() {
	  List<AnimalDTO> lista = new ArrayList<>();
		
		for(Animal animal : repo.findAll()) {
		lista.add(map.map(animal, AnimalDTO.class));  
	    }
		return lista ;
	}
 		
	public AnimalDTO save(AnimalDTO dto){
	 return map.map(repo.save(map.map(dto, Animal.class)) , AnimalDTO.class);	
	} 

	public AnimalDTO edit(AnimalDTO dto) {
	 AnimalDTO retorno = new AnimalDTO();
		
	    if (repo.findById(dto.getId()).isPresent()){
	     return	retorno = map.map(repo.save(map.map(dto, Animal.class)) , AnimalDTO.class);			
		}
		 return null ;
	} 
	
	public AnimalDTO addVacina(Long idAnimal , Long idVacina) {
	  	
		Animal animalRef = repo.getOne(idAnimal) ;
	  	
	  	animalRef.getVacinas().add(repoVacina.getOne(idVacina));
	  	
	  	return new AnimalDTO(repo.save(animalRef));	  	
		
	}
	
}
