package hack.api.com.dto;

import hack.api.com.modelo.Dono;
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
public class DonoDTO {

	private Long id;
	private String nome;
	private String CPF;
	private Integer idade;

	public DonoDTO(Dono d) {
		this.id = d.getId();
		this.nome = d.getNome();
		this.CPF = d.getCPF();

	}

}
