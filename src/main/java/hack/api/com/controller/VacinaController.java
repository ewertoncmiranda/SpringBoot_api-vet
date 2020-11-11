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


import hack.api.com.dto.VacinaDTO;

import hack.api.com.modelo.Vacina;

import hack.api.com.servico.VacinaService;

@RestController
@RequestMapping(value = "/vacina")
public class VacinaController {
	@Autowired
	VacinaService service ;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<VacinaDTO>> findAll(){
		List<VacinaDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista) ;
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<VacinaDTO> save(@RequestBody(required = true) Vacina vcn){
		VacinaDTO dto = service.save(vcn);
		return ResponseEntity.ok().body(dto);		
	}
	
	@GetMapping("/pornome/{nome}") 
	public ResponseEntity<List<VacinaDTO>> findAllByName(@PathVariable(value = "nome",required = true) String nome) {
	List<VacinaDTO> lista = service.findAllByName(nome);
	return ResponseEntity.ok().body(lista) ;		
	}
	
	@GetMapping("/porid/{id}")
	public VacinaDTO findById(@PathVariable(name="id") Long id) {
	return service.findById(id);
	}
	
	@PostMapping("/edit")
	public VacinaDTO edit(@RequestBody Vacina vcn) {
     return service.edit(vcn);		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
	service.delete(id);
	}

	
	
	
	
}
