package hack.api.com.dto;

import java.util.ArrayList;
import java.util.List;

import hack.api.com.modelo.Animal;
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
	private List<Animal> listaDeAnimal ;

	public DonoDTO(Dono d) {
		this.id = d.getDono_id();				
		this.nome = d.getNome();
		this.CPF = d.getCPF();
		this.listaDeAnimal = d.getListaDeAnimais();

	}

}
