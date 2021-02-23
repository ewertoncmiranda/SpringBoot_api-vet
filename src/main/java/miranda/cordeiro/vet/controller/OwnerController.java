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
import miranda.cordeiro.vet.util.response.GeneralResponse;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	OwnerService ownerService ;
	
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<OwnerDTO>>> getListOfOwner(){
	
	GeneralResponse<List<OwnerDTO>> response = new GeneralResponse<>();
	response.setData(ownerService.findAllOwners());	
	response.setHttpStatusCode(HttpStatus.OK.value());
	return ResponseEntity.status(HttpStatus.OK.value()).body(response);
	
	}
	
	@GetMapping("/random")
	public ResponseEntity<Owner> generateNewOwner(){
	
		Owner owner = new Owner();
		owner.setId(10l);
		owner.setName("Sant zu");
		owner.setTelephone("456789");
		return ResponseEntity.ok().body(owner);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponse<OwnerDTO>> findOwnerById(@PathVariable Long id){
		GeneralResponse<OwnerDTO> response = new GeneralResponse<>();
		response.setData(ownerService.findById(id));	
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNewOwner(@RequestBody OwnerDTO newOwner){
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.ownerService.saveNewOwner(newOwner));
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}	
	
	@PutMapping
	public ResponseEntity<GeneralResponse<OwnerDTO>> updateOwner(@RequestBody OwnerDTO owner){
		GeneralResponse<OwnerDTO> response = new GeneralResponse<>();
		response.setData(this.ownerService.updateOnwer(owner));
		response.setHttpStatusCode(HttpStatus.OK.value());		
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GeneralResponse<Boolean>> deleteOwner(@PathVariable Long id){
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(this.ownerService.deleteOwner(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}
	


}





























