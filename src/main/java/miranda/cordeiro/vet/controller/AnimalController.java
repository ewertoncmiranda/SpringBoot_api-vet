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
import miranda.cordeiro.vet.dto.AnimalDTO;
import miranda.cordeiro.vet.entity.Animal;
import miranda.cordeiro.vet.service.AnimalService;
import miranda.cordeiro.vet.util.mplementation.CrudBasicControllerImp;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@RestController
@RequestMapping("/animal")
public class AnimalController implements CrudBasicControllerImp<ResponseEntity,AnimalDTO>{

	@Autowired
	AnimalService animalService ;
	
	@GetMapping("/random")
	public Animal generateNewAnimal(){
		Animal animal = new Animal();
		animal.setId(85l);
		animal.setName("Super Cao Dog Nê");
		animal.setSize(AnimalType.LITTLE_SIZE);
		return animal ;
	}
	
	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse<List<AnimalDTO>>> getListOf() {
		GeneralResponse<List<AnimalDTO>> response = new GeneralResponse<>();
		response.setData(animalService.findAll());
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponse<AnimalDTO>> findById(@PathVariable Long id) {
		GeneralResponse<AnimalDTO> response = new GeneralResponse<>();
		response.setData(animalService.searchById(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNew(@RequestBody AnimalDTO entity) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(animalService.saveNew(entity));
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PutMapping
	public ResponseEntity<GeneralResponse<AnimalDTO>> updateAn(@RequestBody AnimalDTO entity) {
		GeneralResponse<AnimalDTO> response = new GeneralResponse<>();
		response.setData(animalService.updateAn(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@DeleteMapping
	public ResponseEntity<GeneralResponse<Boolean>> deleteAn(@PathVariable Long id) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(animalService.deleteAn(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@PutMapping("/{idAnimal}/add/{idVacina}")
	public ResponseEntity<GeneralResponse<AnimalDTO>> addVacinaToAnimal(@PathVariable Long idAnimal, @PathVariable Long idVacina){
		GeneralResponse<AnimalDTO> response = new GeneralResponse<>();
		response.setData(this.animalService.addVacinaToAnimal(idAnimal, idVacina));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}
	
}
