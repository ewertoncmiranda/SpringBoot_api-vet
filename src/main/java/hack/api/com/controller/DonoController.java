package hack.api.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hack.api.com.dto.DonoDTO;
import hack.api.com.servico.DonoService;

@RestController
@RequestMapping(value = "/dono")
public class DonoController {
	
	@Autowired
	DonoService service ;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<DonoDTO>> findAll(){
		List<DonoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista) ;
	}
	

}
