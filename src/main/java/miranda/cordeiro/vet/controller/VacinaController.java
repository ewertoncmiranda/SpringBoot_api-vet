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

import miranda.cordeiro.vet.dto.VacinaDTO;
import miranda.cordeiro.vet.entity.Vacina;
import miranda.cordeiro.vet.service.VacinaService;
import miranda.cordeiro.vet.util.mplementation.CrudBasicControllerImp;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@RestController
@RequestMapping("/vacina")
public class VacinaController implements CrudBasicControllerImp<ResponseEntity ,VacinaDTO>{
	
	@Autowired
	VacinaService vacinaService ;

	
	
	@GetMapping("/random")	
	public Vacina generateNewVacina() {
		Vacina vacina = new Vacina();
		vacina.setId(88l);
		vacina.setLote("ABC789");
		vacina.setName("Rabica");
		return vacina ;
	}
	
	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse<List<VacinaDTO>>> getListOf() {
		GeneralResponse<List<VacinaDTO>> response = new GeneralResponse<>();
		response.setData(vacinaService.findAll());
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);		
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity <GeneralResponse<VacinaDTO>>findById(@PathVariable Long id) {
		GeneralResponse<VacinaDTO> response = new GeneralResponse<>();
		response.setData(vacinaService.searchById(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PostMapping
	public ResponseEntity<GeneralResponse<Boolean>> saveNew(@RequestBody VacinaDTO entity) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(vacinaService.saveNew(entity));
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@PutMapping
	public ResponseEntity <GeneralResponse<VacinaDTO>>updateAn(@RequestBody VacinaDTO entity) {
		GeneralResponse<VacinaDTO> response = new GeneralResponse<>();
		response.setData(vacinaService.updateAn(entity));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}

	@Override
	@DeleteMapping
	public ResponseEntity<GeneralResponse<Boolean>> deleteAn(@PathVariable Long id) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(vacinaService.deleteAn(id));
		response.setHttpStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
	
	
	

}
