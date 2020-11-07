package hack.api.com.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.DonoDTO;
import hack.api.com.modelo.Dono;
import hack.api.com.modelo.interfaces.MeuCrud;
import hack.api.com.repositorio.DonoRepositorio;

@Service
@Transactional
public class DonoService implements MeuCrud<DonoDTO, Dono> {
	
	@Autowired
	DonoRepositorio repo ;
	
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
	public DonoDTO edit(Long id) {
	 return new DonoDTO (repo.save(repo.findById(id).get()));
	}

	@Override
	public void delete(Long id) {
	 repo.delete(repo.findById(id).get());
	}

	@Override
	public DonoDTO findById(Long id) {
   	return new DonoDTO(repo.findById(id).get()); 
	}

	@Override
	public List<DonoDTO> findAllByName(String pedaco) {
	
		return null;
	}

}
