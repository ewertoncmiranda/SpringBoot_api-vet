package miranda.cordeiro.vet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.cordeiro.vet.entity.Vacina;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDTO {

	private Long id ;
	
	private String name ;
	
	private String lote ;
	
	public VacinaDTO(Vacina vacina) {
		id = vacina.getId();
		name = vacina.getName();
		lote = vacina.getLote();
	}
	
}
