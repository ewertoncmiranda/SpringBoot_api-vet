package hack.api.com.controller;

import java.util.ArrayList;
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
import hack.api.com.servico.DonoService;

@RestController
@RequestMapping(value = "/dono")
public class DonoController {

	@Autowired
	DonoService service;

	@GetMapping
	public ResponseEntity<List<DonoDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DonoDTO> findById(@PathVariable Long id){
	return ResponseEntity.ok(service.findById(id));
	}

	
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody DonoDTO dto){
		service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("ok");	
	}
	
	@PutMapping
	public ResponseEntity<DonoDTO> edit (@RequestBody DonoDTO dono){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(dono));
	}
	


}
