package hack.api.com.servico;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hack.api.com.dto.VacinaDTO;
import hack.api.com.modelo.Vacina;
import hack.api.com.repositorio.VacinaRepositorio;

@Service
@Transactional
public class VacinaService {


	@Autowired
	VacinaRepositorio repos ;
	
	ModelMapper map = new ModelMapper() ;
	
	@Transactional
	public VacinaDTO save(VacinaDTO vacina) {
	 return new VacinaDTO(repos.save(map.map(vacina , Vacina.class)));		
	}
	
	public List<VacinaDTO> findAll(){
		List<VacinaDTO> lista = new ArrayList<>();
		
		for(Vacina v : repos.findAll()) {
			lista.add(new VacinaDTO(v));
		}
		return lista ;
	}

}
