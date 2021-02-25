package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessageVacina;
import miranda.cordeiro.vet.dto.VacinaDTO;
import miranda.cordeiro.vet.entity.Vacina;
import miranda.cordeiro.vet.exception.VacinaException;
import miranda.cordeiro.vet.repository.VacinaRepository;
import miranda.cordeiro.vet.util.mplementation.CrudServiceImp;

@Service
public class VacinaService implements CrudServiceImp<VacinaDTO>{
	
	VacinaRepository vacinaRepository ;
	ModelMapper mapper ;
	
	@Autowired
	public VacinaService(VacinaRepository vacinaRepositoryParam) {
		this.vacinaRepository = vacinaRepositoryParam;
		this.mapper = new ModelMapper();
	}

	@Override
	public List<VacinaDTO> findAll() {
		try {
			List<VacinaDTO> listVacina = new ArrayList<>();
			
			for(Vacina vacina : this.vacinaRepository.findAll()) {
				listVacina.add(mapper.map(vacina, VacinaDTO.class));
			}			
			return listVacina;
		} catch (Exception e) {
			throw new VacinaException(ErrorMessageVacina.ERROR_FIND_VACINA.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public VacinaDTO searchById(Long id) {
		try {
			if(this.vacinaRepository.findById(id).isPresent()) {
				return mapper.map(this.vacinaRepository.findById(id).get(),VacinaDTO.class);
			}else {
			throw new VacinaException(ErrorMessageVacina.ERROR_FIND_VACINA.getValue(), HttpStatus.BAD_REQUEST);
			}				
		} catch (Exception e) {
			throw new VacinaException(ErrorMessageVacina.ERROR_FIND_VACINA.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Boolean saveNew(VacinaDTO entity) {
		try {
			this.vacinaRepository.save(this.mapper.map(entity ,Vacina.class));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new VacinaException(ErrorMessageVacina.ERROR_SAVE_NEW_VACINA.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public VacinaDTO updateAn(VacinaDTO entity) {
		try {
			if(this.vacinaRepository.findById(entity.getId()).isPresent()) {
				return mapper.map(this.vacinaRepository.save(mapper.map(entity,Vacina.class)) ,VacinaDTO.class);				
			}else {
			throw new VacinaException(ErrorMessageVacina.ERROR_FIND_VACINA.getValue(), HttpStatus.BAD_REQUEST);
			}					
			
		} catch (Exception e) {
			throw new VacinaException(ErrorMessageVacina.ERROR_UPDATE_VACINA_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Boolean deleteAn(Long id) {
		try {
			if(this.vacinaRepository.findById(id).isPresent()) {
				this.vacinaRepository.delete(this.vacinaRepository.findById(id).get());
				return Boolean.TRUE;
			}else {
				throw new VacinaException(ErrorMessageVacina.ERRO_DELETE_VACINA.getValue(), HttpStatus.BAD_REQUEST);
			}			
		} catch (Exception e) {
				throw new VacinaException(ErrorMessageVacina.ERRO_DELETE_VACINA.getValue(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
