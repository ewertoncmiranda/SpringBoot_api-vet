package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessageAnimal;
import miranda.cordeiro.vet.dto.AnimalDTO;
import miranda.cordeiro.vet.entity.Animal;
import miranda.cordeiro.vet.exception.AnimalException;
import miranda.cordeiro.vet.repository.AnimalRepository;
import miranda.cordeiro.vet.repository.VacinaRepository;
import miranda.cordeiro.vet.util.mplementation.CrudServiceImp;

@Service
public class AnimalService implements CrudServiceImp<AnimalDTO> {
	
	
	AnimalRepository animalRepository;
	VacinaRepository vacinaRepository ;
	ModelMapper mapper ;
	
	@Autowired
	public AnimalService (AnimalRepository animalRepositoryParam , VacinaRepository vacinaRepositoryParam) {
		this.animalRepository = animalRepositoryParam;
		this.vacinaRepository = vacinaRepositoryParam;
		mapper = new ModelMapper();
	}

	@Override
	public List<AnimalDTO> findAll() {
		try {
			
			List<AnimalDTO> animalDtoList = new ArrayList<>();
			
			for(Animal animal : this.animalRepository.findAll()) {
			 animalDtoList.add(mapper.map(animal, AnimalDTO.class));	
			}			
			return animalDtoList;
			
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERROR_FIND_ANIMAL.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public AnimalDTO searchById(Long id) {
		try {
			return mapper.map(this.animalRepository.findById(id).get(), AnimalDTO.class );
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERROR_FIND_ANIMAL.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Boolean saveNew(AnimalDTO entity) {
		try {
			this.animalRepository.save(mapper.map(entity ,Animal.class));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERROR_SAVE_NEW_ANIMAL.getValue(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public AnimalDTO updateAn(AnimalDTO entity) {
		try {
		  if(this.animalRepository.findById(entity.getId()).isPresent()) {
			  return mapper.map( this.animalRepository.save(mapper.map(entity, Animal.class)) ,AnimalDTO.class);
		  }else {
			throw new AnimalException(ErrorMessageAnimal.ERROR_UPDATE_ANIMAL_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
		  }						
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERROR_UPDATE_ANIMAL_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
		}		
	}

	@Override
	public Boolean deleteAn(Long id) {
		try {
			if(this.animalRepository.findById(id).isPresent()) {
				this.animalRepository.delete(this.animalRepository.findById(id).get());
				return Boolean.TRUE;
			}else {
				throw new AnimalException(ErrorMessageAnimal.ERRO_DELETE_ANIMAL.getValue(), HttpStatus.BAD_REQUEST);
			}			
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERRO_DELETE_ANIMAL.getValue(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public AnimalDTO addVacinaToAnimal(Long idAnimal , Long idVacina) {
		try {			
			if(this.animalRepository.findById(idAnimal).isPresent()) {
				Animal animalHelper = this.animalRepository.getOne(idAnimal);				
					if(this.vacinaRepository.findById(idVacina).isPresent()) {
						 animalHelper.getVacinaList().add(this.vacinaRepository.findById(idVacina).get()) ;
						 
						return new AnimalDTO(this.animalRepository.save(animalHelper));						
					}else {
						throw new AnimalException(ErrorMessageAnimal.ERRO_ADD_VACINA_TO_ANIMAL.getValue(),HttpStatus.NOT_FOUND);
					}				
			}else {
				throw new AnimalException(ErrorMessageAnimal.ERRO_ADD_VACINA_TO_ANIMAL.getValue(),HttpStatus.NOT_FOUND);
			}						
		} catch (Exception e) {
			throw new AnimalException(ErrorMessageAnimal.ERRO_ADD_VACINA_TO_ANIMAL.getValue(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
