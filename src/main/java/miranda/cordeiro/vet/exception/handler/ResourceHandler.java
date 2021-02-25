package miranda.cordeiro.vet.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import miranda.cordeiro.vet.exception.AnimalException;
import miranda.cordeiro.vet.exception.OwnerException;
import miranda.cordeiro.vet.exception.VacinaException;
import miranda.cordeiro.vet.util.response.GeneralResponse;

@ControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(OwnerException.class)
	public ResponseEntity<GeneralResponse<String>> handlerOwnerException(OwnerException exception){
	
		GeneralResponse<String> response = new GeneralResponse<>();		 			
		response.setData(exception.getMessage());
		response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
		
	}
	
	@ExceptionHandler(AnimalException.class)
	public ResponseEntity<GeneralResponse<String>> handlerAnimalExcepetion(AnimalException exception){
		GeneralResponse<String> response = new GeneralResponse<>();
		response.setData(exception.getMessage());
		response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
	

	@ExceptionHandler(VacinaException.class)
	public ResponseEntity<GeneralResponse<String>> handlerVacinaException(VacinaException exception){
		GeneralResponse<String> response = new GeneralResponse<>();
		response.setData(exception.getMessage());
		response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(response.getHttpStatusCode()).body(response);
	}
	
}
