package hack.api.com.servico;

import java.util.ArrayList;
import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
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
		 lista.add(new DonoDTO(dono));		
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
		 			
	    if (repo.findById(dto.getId()).isPresent()){
	     return	 map.map(repo.save(map.map(dto, Dono.class)) , DonoDTO.class);			
		}
		 return null ;
		} 

	public DonoDTO saveWithAnimals(DonoDTO dto){
		Dono dono = new Dono(null, dto.getNome(), dto.getCPF(),dto.getIdade() );
		
		for(AnimalDTO d : dto.getAnimais()) {
			Animal a = repoAnimal.getOne(d.getId());
			dono.getAnimais().add(a);
		}
		return new DonoDTO(repo.save(dono));
		
	}
}
