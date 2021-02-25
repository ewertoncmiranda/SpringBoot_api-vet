package miranda.cordeiro.vet.exception;

import org.springframework.http.HttpStatus;

public class VacinaException extends RuntimeException{

	private static final long serialVersionUID = -8562208196146080649L;
	/**
	 * 
	 */	
	
	private final HttpStatus httpStatus ;
	
	public VacinaException(final String message , final HttpStatus httpStatus) {
		super(message) ;
		this.httpStatus = httpStatus;
	}
	

}
