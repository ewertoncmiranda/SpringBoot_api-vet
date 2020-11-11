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
import hack.api.com.dto.DonoDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
import hack.api.com.servico.AnimalService;
import hack.api.com.servico.DonoService;

@RestController
@RequestMapping(value = "/dono")
public class DonoController {

	@Autowired
	DonoService service;

	@Autowired
	AnimalService serviceAnimal;

	@GetMapping(value = "/all")
	public ResponseEntity<List<DonoDTO>> findAll() {
		List<DonoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<DonoDTO> save(@RequestBody(required = true) Dono dono) {
		DonoDTO dto = service.save(dono);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/pornome/{nome}")
	public ResponseEntity<List<DonoDTO>> findAllByName(@PathVariable(value = "nome", required = true) String nome) {
		List<DonoDTO> lista = service.findAllByName(nome);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/porid/{id}")
	public DonoDTO findById(@PathVariable(name = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping("/edit")
	public DonoDTO edit(@RequestBody Dono dono) {
		return service.edit(dono);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
	
	/**Para adicionar animal a dono , é necessário o dono ja estar criado.
	 * Não é possível criar um animal sem uma associação de dono. Ou seja ,
	 * para cadastrar um animal , é necessário ter um dono Criado.	 * 
	 * **/
	@PostMapping("/adicionarAnimal/{idDono}")
	public ResponseEntity<DonoDTO> addBicho(@PathVariable(name = "idDono") Long idDono, @RequestBody Animal animal) {
	return ResponseEntity.ok().body(service.adicionarAnimal(idDono,  serviceAnimal.save(animal).DtoToAnimal()));
	}

}
