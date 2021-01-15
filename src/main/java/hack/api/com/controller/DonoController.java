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


import hack.api.com.dto.DonoDTO;
import hack.api.com.servico.DonoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/dono")
public class DonoController {

	@Autowired
	DonoService service;
	
	@ApiOperation(value = "Lista todos os Donos.")
	@GetMapping
	public ResponseEntity<List<DonoDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
	}
	@ApiOperation(value = "Busca o Dono pelo ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<DonoDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}	
	
	@ApiOperation(value = "Salva um novo Dono.")
	@PostMapping
	public ResponseEntity<DonoDTO> save(@RequestBody DonoDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));	
	}
	@ApiOperation(value = "Edita uma entidade de Dono.")
	@PutMapping
	public ResponseEntity<DonoDTO> edit (@RequestBody DonoDTO dono){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(dono));
	}
	
	@ApiOperation(value = "Adiciona um Animal para um Dono.")
	@PutMapping (value = "/{idDono}/add/{idAnimal}")
	public ResponseEntity<DonoDTO> addAnimal(@PathVariable Long idDono, @PathVariable Long idAnimal){
	    return ResponseEntity.status(HttpStatus.OK).body(service.addAnimal(idDono, idAnimal));	
	}

}
