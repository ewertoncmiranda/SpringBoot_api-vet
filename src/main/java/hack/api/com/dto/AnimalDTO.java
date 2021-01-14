package hack.api.com.dto;

import java.io.Serializable;

import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnimalDTO implements Serializable{

private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String raca;
	private int peso;
	
	public AnimalDTO(Animal a) {
		id = a.getId();
		nome = a.getNome();
		raca = a.getRaca() ;
		peso = a.getPeso();
	}
	
}
