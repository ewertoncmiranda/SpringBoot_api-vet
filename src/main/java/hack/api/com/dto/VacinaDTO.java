package hack.api.com.dto;

import hack.api.com.modelo.Vacina;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class VacinaDTO {
	
	private Long id;

	private String nome;

	private Integer lote;

	public VacinaDTO(Long id, String nome, Integer lote) {
		this.id = id;
		this.nome = nome;
		this.lote = lote;
	}

	public VacinaDTO(Vacina v) {
		id = v.getId();
		nome = v.getNome();
		lote = v.getLote();
	}

}
