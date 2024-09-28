package hack.api.com.controller;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.servico.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
	
	@Autowired
	AnimalService service ;
	

	@PostMapping
	public ResponseEntity<AnimalDTO> save(@RequestBody AnimalDTO dto){
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));	
	}
	

	@GetMapping
	public ResponseEntity<List<AnimalDTO>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());	
	}
	

	@PutMapping
	public ResponseEntity<AnimalDTO> edit (@RequestBody AnimalDTO animal){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(animal));
	}

	@PutMapping(value = "/{idAnimal}/add/{idVacina}")
	public ResponseEntity<AnimalDTO> addVacina(@PathVariable Long idAnimal , @PathVariable Long idVacina){
	 return ResponseEntity.status(HttpStatus.OK).body(service.addVacina(idAnimal, idVacina));
	}	

}
