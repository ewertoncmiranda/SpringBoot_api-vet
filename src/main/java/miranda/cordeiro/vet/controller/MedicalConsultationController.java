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

import miranda.cordeiro.vet.constant.AnimalType;
import miranda.cordeiro.vet.dto.MedicalConsultationDTO;
import miranda.cordeiro.vet.entity.Animal;
import miranda.cordeiro.vet.entity.MedicalConsultation;
import miranda.cordeiro.vet.entity.MedicalDoctor;
import miranda.cordeiro.vet.entity.Owner;
import miranda.cordeiro.vet.service.MedicalConsultationService;
import miranda.cordeiro.vet.util.mplementation.CrudBasicControllerImp;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/consultation")
public class MedicalConsultationController implements CrudBasicControllerImp<ResponseEntity,MedicalConsultationDTO>{

	@Autowired
	MedicalConsultationService consultationService ;

	
	@GetMapping("/random")
	public MedicalConsultation generateConsultation() {
		MedicalConsultation consultation = new MedicalConsultation();
		consultation.setId(2L);
		consultation.setAnimal(new Animal(10l, "DogSauro", AnimalType.BIG_SIZE, null));
		consultation.setDoctor(new MedicalDoctor(88l, "Doutor Estranho","6969696969","cop789df"));
		consultation.setOwner(new Owner(7l,"Rogerinho","789456126", null));
		consultation.setDate("16/09/20");		
		
		return consultation;		
	}
	
	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse<List<MedicalConsultationDTO>>> getListOf() {
		GeneralResponse<List<MedicalConsultationDTO>> response = new GeneralResponse<>();
		response.setData(consultationService.findAll());
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponse<MedicalConsultationDTO>> findById(@PathVariable Long id) {
		GeneralResponse<MedicalConsultationDTO> response = new GeneralResponse<>();
		response.setData(consultationService.searchById(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}

	@Override
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNew(@RequestBody MedicalConsultationDTO entity) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(consultationService.saveNew(entity));
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}

	@Override
	@PutMapping
	public ResponseEntity<GeneralResponse<MedicalConsultationDTO>> updateAn(@RequestBody MedicalConsultationDTO entity) {
		GeneralResponse<MedicalConsultationDTO> response = new GeneralResponse<>();
		response.setData(consultationService.updateAn(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}

	@Override
	@DeleteMapping
	public ResponseEntity<GeneralResponse<Boolean>> deleteAn(@PathVariable Long id) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(consultationService.deleteAn(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
	}
	
	@PutMapping("/{idConsultation}/with/{idDoctor}/add/{idOwner}/add/{idAnimal}")
	public ResponseEntity<GeneralResponse<MedicalConsultationDTO>> createConsultation
	  (@PathVariable Long idConsultation,@PathVariable Long idDoctor ,@PathVariable Long idOwner ,@PathVariable Long idAnimal ){
		GeneralResponse<MedicalConsultationDTO> response = new GeneralResponse<>();
		response.setData(consultationService.createConsultation(idConsultation, idDoctor, idOwner, idAnimal));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response) ;
		
	}
	
	
}
