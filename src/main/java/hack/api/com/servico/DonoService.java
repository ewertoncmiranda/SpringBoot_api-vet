package hack.api.com.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.DonoDTO;
import hack.api.com.modelo.Dono;
import hack.api.com.repositorio.DonoRepositorio;

@Service
public class DonoService {
	
	@Autowired
	DonoRepositorio repo ;
	
	@Transactional(readOnly = true)
	public List<DonoDTO> findall(){
		List<Dono> lista = repo.findAll();
		return lista.stream().map(dono -> new DonoDTO()).collect(Collectors.toList());		
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

}
