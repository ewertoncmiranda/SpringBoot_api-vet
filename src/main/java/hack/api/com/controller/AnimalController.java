package hack.api.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.dto.DonoDTO;
import hack.api.com.servico.AnimalService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
	
	@Autowired
	AnimalService service ;
	
	@ApiOperation(value = "Salva um novo Animal.")
	@PostMapping
	public ResponseEntity<AnimalDTO> save(@RequestBody AnimalDTO dto){
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));	
	}
	
	@ApiOperation(value = "Lista todos os Animais.")
	@GetMapping
	public ResponseEntity<List<AnimalDTO>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());	
	}
	
	@ApiOperation(value = "Edita um Animal.")
	@PutMapping
	public ResponseEntity<AnimalDTO> edit (@RequestBody AnimalDTO animal){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(animal));
	}
	
	@ApiOperation(value = "Adiciona uma Vacina a um Animal.")
	@PutMapping(value = "/{idAnimal}/add/{idVacina}")
	public ResponseEntity<AnimalDTO> addVacina(@PathVariable Long idAnimal , @PathVariable Long idVacina){
	 return ResponseEntity.status(HttpStatus.OK).body(service.addVacina(idAnimal, idVacina));
	}	

}
