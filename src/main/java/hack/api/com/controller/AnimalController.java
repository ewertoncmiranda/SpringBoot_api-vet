package hack.api.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.servico.AnimalService;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
	
	@Autowired
	AnimalService service ;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AnimalDTO>> findall(){
		List<AnimalDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<AnimalDTO> save(@RequestBody (required = true) Animal animal) {
	AnimalDTO dto = service.save(animal);
	return ResponseEntity.ok().body(dto) ;		
	}
	
	
	@GetMapping("/pornome/{nome}") 
	public ResponseEntity<List<AnimalDTO>> findAllByName(@PathVariable(value = "nome",required = true) String nome) {
	List<AnimalDTO> lista = service.findAllByName(nome);
	return ResponseEntity.ok().body(lista) ;		
	}
	
	@GetMapping("/porid/{id}")
	public AnimalDTO findById(@PathVariable(name="id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/edit")
	public AnimalDTO edit(@RequestBody Animal animal) {
    	 return service.edit(animal);		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}

}
