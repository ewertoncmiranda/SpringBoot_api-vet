package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessageAnimal;
import miranda.cordeiro.vet.constant.ErrorMessageConsultationMedical;
import miranda.cordeiro.vet.constant.ErrorMessageMedicalDoctor;
import miranda.cordeiro.vet.constant.ErrorMessageOwner;
import miranda.cordeiro.vet.dto.MedicalConsultationDTO;
import miranda.cordeiro.vet.entity.MedicalConsultation;
import miranda.cordeiro.vet.exception.AnimalException;
import miranda.cordeiro.vet.exception.MedicalConsultationException;
import miranda.cordeiro.vet.exception.MedicalDoctorException;
import miranda.cordeiro.vet.exception.OwnerException;
import miranda.cordeiro.vet.repository.AnimalRepository;
import miranda.cordeiro.vet.repository.MedicalConsultationRepository;
import miranda.cordeiro.vet.repository.MedicalDoctorRepository;
import miranda.cordeiro.vet.repository.OwnerRepository;
import miranda.cordeiro.vet.util.mplementation.CrudServiceImp;

@Service
public class MedicalConsultationService implements CrudServiceImp<MedicalConsultationDTO> {

	OwnerRepository ownerRepository;
	AnimalRepository animalRepository;
	MedicalDoctorRepository doctorRepository;
	MedicalConsultationRepository consultationRepository;
	ModelMapper mapper ;

	@Autowired
	public MedicalConsultationService(OwnerRepository ownerRepositoryParam, AnimalRepository animalRepositorParam,
			MedicalDoctorRepository doctorRepositoryParam, MedicalConsultationRepository consultationRepositoryParam) {
		ownerRepository = ownerRepositoryParam;
		animalRepository = animalRepositorParam;
		doctorRepository = doctorRepositoryParam;
		consultationRepository = consultationRepositoryParam;
		mapper = new ModelMapper();
	}

	@Override
	public List<MedicalConsultationDTO> findAll() {
		try {
			List<MedicalConsultationDTO> listConsultation = new ArrayList<>();			
			for(MedicalConsultation consultation : this.consultationRepository.findAll()) {
				listConsultation.add(new MedicalConsultationDTO(consultation));
			}			
			return listConsultation;			
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_FIND_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public MedicalConsultationDTO searchById(Long id) {
		try {
			return mapper.map(this.consultationRepository.findById(id).get(), MedicalConsultationDTO.class);
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_FIND_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Boolean saveNew(MedicalConsultationDTO entity) {
		try {
			this.consultationRepository.save(mapper.map(entity,MedicalConsultation.class));
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_SAVE_NEW_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public MedicalConsultationDTO updateAn(MedicalConsultationDTO entity) {
		try {
			if (this.consultationRepository.findById(entity.getId()).isPresent()) {
				return mapper.map( this.consultationRepository.save(mapper.map(entity,MedicalConsultation.class)) ,MedicalConsultationDTO.class);
			} else {
				throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_UPDATE_CONSULTATION_BY_ID.getValue(),HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_UPDATE_CONSULTATION_BY_ID.getValue(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Boolean deleteAn(Long id) {
		try {
			if (this.consultationRepository.findById(id).isPresent()) {
				this.consultationRepository.delete(this.consultationRepository.findById(id).get());
				return Boolean.TRUE;
			} else {
				throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERRO_DELETE_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERRO_DELETE_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
		}
	}

	public MedicalConsultationDTO createConsultation(Long idConsultation,Long idDoctor ,Long idOwner , Long idAnimal ){
		try {
			if(this.consultationRepository.findById(idConsultation).isPresent()) {
				if(this.doctorRepository.findById(idDoctor).isPresent()) {
					if(this.ownerRepository.findById(idOwner).isPresent()) {
					   if(this.animalRepository.findById(idAnimal).isPresent()) {
						   
						   MedicalConsultation consultation = this.consultationRepository.findById(idConsultation).get();
						   consultation.setAnimal(this.animalRepository.findById(idAnimal).get());
						   consultation.setDoctor(this.doctorRepository.findById(idDoctor).get());
						   consultation.setOwner(this.ownerRepository.findById(idOwner).get());
						   
						   
						   return new MedicalConsultationDTO(this.consultationRepository.save(consultation));						   
						   
					   }else {
						throw new AnimalException(ErrorMessageAnimal.ERROR_FIND_ANIMAL.getValue(),HttpStatus.BAD_REQUEST);   
					   }							
					}else {
					 throw new OwnerException(ErrorMessageOwner.ERROR_FIND_OWNER.getValue() ,HttpStatus.BAD_REQUEST );	
					}					
				}else {
				throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_FIND_DOCTOR.getValue(), HttpStatus.BAD_REQUEST);	
				}					
			}else {
				throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERROR_FIND_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
			}							
		} catch (Exception e) {
			throw new MedicalConsultationException(ErrorMessageConsultationMedical.ERRO_GENERATE_CONSULTATION.getValue(),HttpStatus.BAD_REQUEST);
		}		
	}
	
}
