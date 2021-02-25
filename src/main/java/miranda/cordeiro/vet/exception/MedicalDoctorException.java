package miranda.cordeiro.vet.exception;

import org.springframework.http.HttpStatus;

public class MedicalDoctorException extends RuntimeException{

	private static final long serialVersionUID = -8562208196146080649L;
	
	/**
	 * 
	 */	
	
	private final HttpStatus httpStatus ;
	
	public MedicalDoctorException(final String message , final HttpStatus httpStatus) {
		super(message) ;
		this.httpStatus = httpStatus;
	}
	

}
