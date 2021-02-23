package miranda.cordeiro.vet.util.response;

import java.time.Instant;

import lombok.Data;



@Data
public class GeneralResponse<T> {

	private T data ;
	private int httpStatusCode ;
	private Instant timeStamp =  Instant.now();	
	
}
