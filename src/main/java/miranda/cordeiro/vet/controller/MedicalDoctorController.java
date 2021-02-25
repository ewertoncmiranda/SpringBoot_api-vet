package miranda.cordeiro.vet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miranda.cordeiro.vet.dto.MedicalDoctorDTO;
import miranda.cordeiro.vet.entity.MedicalDoctor;
import miranda.cordeiro.vet.service.MedicalDoctorService;
import miranda.cordeiro.vet.util.mplementation.CrudBasicControllerImp;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@RestController
@RequestMapping("/doctor")
public class MedicalDoctorController implements CrudBasicControllerImp<ResponseEntity, MedicalDoctorDTO>{

	@Autowired
	MedicalDoctorService medicalService ;

	@GetMapping("/random")
	public MedicalDoctor generateMedicalDoctor() {
		MedicalDoctor doctor = new MedicalDoctor();
		doctor.setCrm("45ab78");
		doctor.setId(100l);
		doctor.setTelephone("19894567894");
		doctor.setName("Professor Aloprado");		
		return doctor ;
	}
	
	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse<List<MedicalDoctorDTO>>> getListOf() {
	GeneralResponse<List<MedicalDoctorDTO>> response = new GeneralResponse<>();
	response.setData(this.medicalService.findAll());
	response.setHttpStatusCode(HttpStatus.OK.value());
	return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}	
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponse<MedicalDoctorDTO>> findById(@PathVariable Long id) {
		GeneralResponse<MedicalDoctorDTO> response = new GeneralResponse<>();
		response.setData(this.medicalService.searchById(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNew(@RequestBody MedicalDoctorDTO entity) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.medicalService.saveNew(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}

	@Override
	@PutMapping
	public ResponseEntity<GeneralResponse<MedicalDoctorDTO>> updateAn(@RequestBody MedicalDoctorDTO entity) {
		GeneralResponse<MedicalDoctorDTO> response = new GeneralResponse<>();
		response.setData(this.medicalService.updateAn(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<GeneralResponse<Boolean>> deleteAn(@PathVariable Long id) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.medicalService.deleteAn(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
	
}
