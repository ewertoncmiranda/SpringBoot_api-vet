package hack.api.com.dto;

import hack.api.com.modelo.Vacina;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VacinaDTO {

	private Long id;
	private String nome;
	private int lote;
	
	public VacinaDTO(Vacina vcn) {
		this.id = vcn.getId();
		this.nome = vcn.getNome();
		this.lote = vcn.getLote();
	}
}
