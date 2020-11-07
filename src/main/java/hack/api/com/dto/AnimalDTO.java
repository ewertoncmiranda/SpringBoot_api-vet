package hack.api.com.dto;

import java.io.Serializable;

import hack.api.com.modelo.Animal;
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
public class AnimalDTO implements Serializable{

private static final long serialVersionUID = 1L;

private Long id;
private String nome;
private String raca;
private Integer peso;


public AnimalDTO(Animal animal) {
	this.id = animal.getId();
	this.nome = animal.getNome();
	this.raca = animal.getRaca();
	this.peso = animal.getPeso();

}

public Animal get(AnimalDTO dto) {
	Animal animal = new Animal();
	animal.setId(dto.getId()) ;
	animal.setNome(dto.getNome());
	animal.setRaca(dto.getRaca());
	animal.setPeso(dto.getPeso());
	return animal;
}


}
