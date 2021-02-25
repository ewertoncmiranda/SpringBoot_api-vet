package miranda.cordeiro.vet.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miranda.cordeiro.vet.entity.Owner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {

	private Long id ;
	
	private String name ;
	
	private String telephone ;
	
	private List<AnimalDTO> animalList = new ArrayList<>();
	
	public OwnerDTO(Owner owner) {
		id = owner.getId();
		name = owner.getName();
		telephone = owner.getTelephone();
		
		animalList = owner.getAnimalList().stream().map(
			animal -> new AnimalDTO(animal)).collect(Collectors.toList());				
	}	
	
}
