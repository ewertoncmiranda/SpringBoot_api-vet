package miranda.cordeiro.vet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import miranda.cordeiro.vet.constant.ErrorMessageMedicalDoctor;
import miranda.cordeiro.vet.dto.MedicalDoctorDTO;
import miranda.cordeiro.vet.entity.MedicalDoctor;
import miranda.cordeiro.vet.exception.MedicalDoctorException;
import miranda.cordeiro.vet.repository.MedicalDoctorRepository;
import miranda.cordeiro.vet.util.mplementation.CrudServiceImp;

@Service
public class MedicalDoctorService implements CrudServiceImp<MedicalDoctorDTO>{

	MedicalDoctorRepository doctorRepository ;
	ModelMapper mapper ;
	@Autowired
	public MedicalDoctorService(MedicalDoctorRepository doctorRepositoryParam) {
		this.doctorRepository =doctorRepositoryParam;
		this.mapper = new ModelMapper();
	
	}
	
	@Override
	public List<MedicalDoctorDTO> findAll() {
		try {
			List<MedicalDoctorDTO> doctorDtoList = new ArrayList<>();
			
			for(MedicalDoctor doctor : doctorRepository.findAll() ) {
				doctorDtoList.add(new MedicalDoctorDTO(doctor));
			}
			return doctorDtoList;			
			
		} catch (Exception e) {
			throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_FIND_DOCTOR.getValue(), HttpStatus.BAD_REQUEST) ;
		}
	}

	@Override
	public MedicalDoctorDTO searchById(Long id) {
		try {
			return new MedicalDoctorDTO(this.doctorRepository.findById(id).get());			
		} catch (Exception e) {
			throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_FIND_DOCTOR.getValue(), HttpStatus.BAD_REQUEST) ;
		}
	}

	@Override
	public Boolean saveNew(MedicalDoctorDTO entity) {
		try {			
			this.doctorRepository.save(mapper.map(entity, MedicalDoctor.class));			
			return Boolean.TRUE;			
		} catch (Exception e) {
			throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_SAVE_NEW_DOCTOR.getValue(), HttpStatus.BAD_REQUEST) ;
		}
	}

	@Override
	public MedicalDoctorDTO updateAn(MedicalDoctorDTO entity) {
		try {
			if(this.doctorRepository.findById(entity.getId()).isPresent()) {
				return mapper.map(this.doctorRepository.save( mapper.map(entity,MedicalDoctor.class)) , MedicalDoctorDTO.class);
			}else {
				throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_UPDATE_DOCTOR_BY_ID.getValue(), HttpStatus.BAD_REQUEST) ;
			}				
		} catch (Exception e) {
			throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERROR_UPDATE_DOCTOR_BY_ID.getValue(), HttpStatus.BAD_REQUEST) ;
		}
	}

	@Override
	public Boolean deleteAn(Long id) {
		try {
			if(this.doctorRepository.findById(id).isPresent()) {
				this.doctorRepository.delete(this.doctorRepository.findById(id).get());
				return Boolean.TRUE;
			}else {
				throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERRO_DELETE_DOCTOR.getValue(), HttpStatus.BAD_REQUEST) ;
			}				
		} catch (Exception e) {
			throw new MedicalDoctorException(ErrorMessageMedicalDoctor.ERRO_DELETE_DOCTOR.getValue(), HttpStatus.BAD_REQUEST) ;
		}
	}
	
	

}
