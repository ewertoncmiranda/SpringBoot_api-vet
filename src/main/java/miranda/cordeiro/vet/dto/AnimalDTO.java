package miranda.cordeiro.vet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.cordeiro.vet.constant.AnimalType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
	
	private Long id ;
	
	private String name ;
	
	private AnimalType size;
	
}
