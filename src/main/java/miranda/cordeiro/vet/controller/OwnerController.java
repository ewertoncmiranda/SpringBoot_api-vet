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

import miranda.cordeiro.vet.dto.OwnerDTO;
import miranda.cordeiro.vet.entity.Owner;
import miranda.cordeiro.vet.service.OwnerService;
import miranda.cordeiro.vet.util.mplementation.CrudBasicControllerImp;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@RestController
@RequestMapping("/owner")
public class OwnerController implements CrudBasicControllerImp<ResponseEntity , OwnerDTO> {
	
	@Autowired
	OwnerService ownerService ;
		
	
	@GetMapping("/random")
	public ResponseEntity<Owner> generateNewOwner(){	
		Owner owner = new Owner();
		owner.setId(10l);
		owner.setName("Sant zu");
		owner.setTelephone("456789");
		return ResponseEntity.ok().body(owner);		
	}
	

	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse<List<OwnerDTO>>> getListOf() {		
		GeneralResponse<List<OwnerDTO>> response = new GeneralResponse<>();
		response.setData(ownerService.findAll());	
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);		
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponse<OwnerDTO>> findById(@PathVariable Long id) {
		GeneralResponse<OwnerDTO> response = new GeneralResponse<>();
		response.setData(ownerService.searchById(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNew(@RequestBody OwnerDTO entity) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.ownerService.saveNew(entity));
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PutMapping
	public ResponseEntity<GeneralResponse<OwnerDTO>> updateAn(@RequestBody OwnerDTO entity) {

		GeneralResponse<OwnerDTO> response = new GeneralResponse<>();
		response.setData(this.ownerService.updateAn(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<GeneralResponse<Boolean>> deleteAn(@PathVariable Long id) {

		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.ownerService.deleteAn(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@PutMapping(value = "/{idOwner}/add/{idAnimal}")
	public ResponseEntity<GeneralResponse<OwnerDTO>> addAnimalToDono(@PathVariable Long idOwner , @PathVariable Long idAnimal){
		GeneralResponse<OwnerDTO> response = new GeneralResponse<>();
		response.setData(this.ownerService.addAnimalToDono(idOwner, idAnimal));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}
}