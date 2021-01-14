package hack.api.com.servico;

import java.util.ArrayList;
import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.dto.DonoDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
import hack.api.com.repositorio.AnimalRepositorio;
import hack.api.com.repositorio.DonoRepositorio;

@Service
@Transactional
public class DonoService  {
	
	@Autowired
	DonoRepositorio repo ;
	
	@Autowired
	AnimalRepositorio repoAnimal ;
	
	ModelMapper map = new ModelMapper();
	
	@Transactional(readOnly = true)
	public List<DonoDTO> findAll(){
	List<DonoDTO> lista = new ArrayList<>();
	    for (Dono dono : repo.findAll()) {
		 lista.add(map.map(dono, DonoDTO.class));		
		}
	 return lista ;				
	}	
	
	@Transactional
	public DonoDTO findById(Long id) {
	return map.map(repo.findById(id).get(), DonoDTO.class);	
	}
	
	
	public DonoDTO save(DonoDTO dono){
	  return map.map(repo.save(map.map(dono, Dono.class)) ,DonoDTO.class);
	}

	public DonoDTO edit(DonoDTO dto) {
		 DonoDTO retorno = new DonoDTO();
			
		    if (repo.findById(dto.getId()).isPresent()){
		     return	retorno = map.map(repo.save(map.map(dto, Dono.class)) , DonoDTO.class);			
			}
			 return null ;
		} 

	public void saveWithAnimals(DonoDTO dto){
		
		List<Animal> listaAnimais = new ArrayList<>();
		
		if(!dto.getAnimais().isEmpty()) {
			
			dto.getAnimais().forEach(animal ->{
				
				if(this.repo.findById(animal).isPresent()) {
					listaAnimais.add(this.repoAnimal.findById(animal).get());
				}
			});			
		}
		Dono dono = new Dono();
		dono.setCPF(dto.getCPF());
		dono.setIdade(dto.getIdade());
		dono.setNome(dto.getNome());
		dono.setAnimais(listaAnimais);
		
		this.repo.save(dono);		
		
	}
}
