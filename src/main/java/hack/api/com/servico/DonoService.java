package hack.api.com.servico;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.DonoDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
import hack.api.com.modelo.interfaces.MeuCrud;
import hack.api.com.repositorio.AnimalRepositorio;
import hack.api.com.repositorio.DonoRepositorio;

@Service
@Transactional
public class DonoService implements MeuCrud<DonoDTO, Dono> {
	
	@Autowired
	DonoRepositorio repo ;
	
	@Autowired
	AnimalRepositorio repoAnimal ;
	
	@Transactional(readOnly = true)
	public List<DonoDTO> findAll(){
		List<Dono> lista = repo.findAll();
	
		
		return lista.stream().map(dono -> new DonoDTO(dono)).collect(Collectors.toList());		
	}
	
	@Transactional
	public List<DonoDTO>saveAll(List<Dono> lista){
		Iterable<Dono> it = lista ;
		List <Dono> dto = repo.saveAll(it);
		return dto.stream().map(dono -> new DonoDTO()).collect(Collectors.toList());
	}
	
	@Transactional
	public DonoDTO save(Dono dono){
	 DonoDTO d1 = new DonoDTO(repo.save(dono));
	 return d1;		
	}

	@Override
	public DonoDTO edit(Dono dono) {
	  Dono d = null ;
	  if(repo.existsById(dono.getDono_id())) {
		  d = repo.save(dono);
	  }
	  return new DonoDTO(d);
		
	}

	@Override
	public void delete(Long id) {
		if (repo.existsById(id)) {
			repo.delete(repo.findById(id).get());
		} else {
			System.out.println("---------DONO NÃO EXISTE---------");
		}
	}

	@Override
	public DonoDTO findById(Long id) {
   	return new DonoDTO(repo.findById(id).get()); 
	}

	/*
	 * @Override public List<DonoDTO> findAllByName(String pedaco) { List<Dono> dto
	 * = repo.findAllByName(pedaco); return dto.stream().map(dono -> new
	 * DonoDTO(dono)).collect(Collectors.toList()); }
	 */
	@Transactional
	public DonoDTO adicionarAnimal(Long idDono ,Animal animal) {
	
		Dono dono = repo.findById(idDono).get();
		
		dono.getListaDeAnimais().add(animal);
		
		//Amarração forçada entre Dono e 	
		for(int pos = 0 ; pos<dono.getListaDeAnimais().size() ;pos++) {
		 dono.getListaDeAnimais().get(pos).setDono(dono);	
		}
							
	    return new DonoDTO(repo.save(dono)) ;	
	}

	@Override
	public List<DonoDTO> findAllByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
