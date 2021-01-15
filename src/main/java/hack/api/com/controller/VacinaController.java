package hack.api.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hack.api.com.dto.VacinaDTO;
import hack.api.com.servico.VacinaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/vacina")
public class VacinaController {
	
	@Autowired
	VacinaService service ;
	
	@ApiOperation(value = "Salva uma nova Vacina.")
	@PostMapping
	public ResponseEntity<VacinaDTO> save(@RequestBody VacinaDTO vacina){
	return ResponseEntity.ok(service.save(vacina));	
	}
	
	@ApiOperation(value = "Lista todas as Vacinas.")
	@GetMapping
	public ResponseEntity<List<VacinaDTO>> findAll(){
	return ResponseEntity.ok(service.findAll()) ;	
	}

}
