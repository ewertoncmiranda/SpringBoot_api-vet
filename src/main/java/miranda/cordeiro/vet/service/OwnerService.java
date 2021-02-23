package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessage;
import miranda.cordeiro.vet.dto.OwnerDTO;
import miranda.cordeiro.vet.entity.Owner;
import miranda.cordeiro.vet.exception.OwnerException;
import miranda.cordeiro.vet.repository.OwnerRepository;


@Service
public class OwnerService {

	OwnerRepository ownerRepository ;
	ModelMapper mapper ;
	
	@Autowired 
	public OwnerService(OwnerRepository repository) {
		this.ownerRepository = repository;
		mapper = new ModelMapper();
	}	
	
	
	public List<OwnerDTO> findAllOwners() {	
		try {
			List<OwnerDTO> ownerDtoList = new ArrayList<>();
			
			for(Owner owner : this.ownerRepository.findAll()) {
				ownerDtoList.add(mapper.map(owner, OwnerDTO.class));				
			}			
			return ownerDtoList;
					
		} catch (Exception e) {
			throw new OwnerException(ErrorMessage.ERROR_FIND_OWNER.getValue(), HttpStatus.BAD_REQUEST);
		}	
		
	}
	
	
	public OwnerDTO findById(Long id) {
		try {
			return mapper.map(this.ownerRepository.findById(id).get() , OwnerDTO.class);
			
		} catch (Exception e) {
			throw new OwnerException(ErrorMessage.ERROR_FIND_OWNER.getValue(), HttpStatus.BAD_REQUEST); 
		}
	}
	
	public Boolean saveNewOwner(OwnerDTO newOwner) {
	
		try {
			this.ownerRepository.save(mapper.map(newOwner, Owner.class));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new OwnerException(ErrorMessage.ERROR_SAVE_NEW_OWNER.getValue(), HttpStatus.BAD_REQUEST);
		}		
	}	

	public OwnerDTO updateOnwer(OwnerDTO owner) {
		try {
			
			if(this.ownerRepository.findById(owner.getId()).isPresent()) {
				return mapper.map(this.ownerRepository.save(mapper.map(owner, Owner.class)), OwnerDTO.class);
			}else {
				throw new OwnerException(ErrorMessage.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			throw new OwnerException(ErrorMessage.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public Boolean deleteOwner(Long id) {
		try {

			if (this.ownerRepository.findById(id).isPresent()) {
				this.ownerRepository.delete(this.ownerRepository.findById(id).get());
				return Boolean.TRUE;
			} else {
				throw new OwnerException(ErrorMessage.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			throw new OwnerException(ErrorMessage.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
