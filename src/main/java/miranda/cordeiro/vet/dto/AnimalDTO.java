package miranda.cordeiro.vet.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.cordeiro.vet.constant.AnimalType;
import miranda.cordeiro.vet.entity.Animal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
	
	private Long id ;
	
	private String name ;
	
	private AnimalType size;
	
	private List<VacinaDTO> listVacina = new ArrayList<>();
	
	public AnimalDTO(Animal animal) {
		id = animal.getId();
		name = animal.getName();
		size = animal.getSize();
		listVacina = animal.getVacinaList().stream().map(
			vacina -> new VacinaDTO(vacina)).collect(Collectors.toList());
	}
	
}
