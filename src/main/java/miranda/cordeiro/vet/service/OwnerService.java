package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessageDono;
import miranda.cordeiro.vet.dto.OwnerDTO;
import miranda.cordeiro.vet.entity.Owner;
import miranda.cordeiro.vet.exception.OwnerException;
import miranda.cordeiro.vet.repository.OwnerRepository;
import miranda.cordeiro.vet.util.response.implementation.CrudServiceImp;


@Service
public class OwnerService implements CrudServiceImp<OwnerDTO> {

	OwnerRepository ownerRepository ;
	ModelMapper mapper ;
	
	@Autowired 
	public OwnerService(OwnerRepository repository) {
		this.ownerRepository = repository;
		mapper = new ModelMapper();
	}	
	

	@Override
	public List<OwnerDTO> findAll() {

		try {
			List<OwnerDTO> ownerDtoList = new ArrayList<>();

			for (Owner owner : this.ownerRepository.findAll()) {
				ownerDtoList.add(mapper.map(owner, OwnerDTO.class));
			}
			return ownerDtoList;

		} catch (Exception e) {
			throw new OwnerException(ErrorMessageDono.ERROR_FIND_OWNER.getValue(), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public OwnerDTO searchById(Long id) {

		try {
			return mapper.map(this.ownerRepository.findById(id).get(), OwnerDTO.class);

		} catch (Exception e) {
			throw new OwnerException(ErrorMessageDono.ERROR_FIND_OWNER.getValue(), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public Boolean saveNew(OwnerDTO entity) {

		try {
			this.ownerRepository.save(mapper.map(entity, Owner.class));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new OwnerException(ErrorMessageDono.ERROR_SAVE_NEW_OWNER.getValue(), HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public OwnerDTO updateAn(OwnerDTO entity) {

		try {

			if (this.ownerRepository.findById(entity.getId()).isPresent()) {
				return mapper.map(this.ownerRepository.save(mapper.map(entity, Owner.class)), OwnerDTO.class);
			} else {
				throw new OwnerException(ErrorMessageDono.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			throw new OwnerException(ErrorMessageDono.ERROR_UPDATE_OWNER_BY_ID.getValue(), HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public Boolean deleteAn(Long id) {

		try {

			if (this.ownerRepository.findById(id).isPresent()) {
				this.ownerRepository.delete(this.ownerRepository.findById(id).get());
				return Boolean.TRUE;
			} else {
				throw new OwnerException(ErrorMessageDono.ERRO_DELETE_OWNER.getValue(), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			throw new OwnerException(ErrorMessageDono.ERRO_DELETE_OWNER.getValue(), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	
}
