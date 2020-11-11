package hack.api.com.dto;

import java.io.Serializable;
import java.util.List;

import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
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
public class AnimalDTO implements Serializable{

private static final long serialVersionUID = 1L;

private Long id;
private String nome;
private String raca;
private Integer peso;
private List<Vacina> listaDeVacinas ;
private Dono dono ;


public AnimalDTO(Animal animal) {
	this.id = animal.getAnimal_id();
	this.nome = animal.getNome();
	this.raca = animal.getRaca();
	this.peso = animal.getPeso();
	this.listaDeVacinas = animal.getListaDeVacinas();
	this.dono = animal.getDono();
}

public Animal DtoToAnimal() {
Animal animal = new Animal ();
animal.setAnimal_id(this.id);
animal.setDono(this.dono);
animal.setNome(this.nome);
animal.setRaca(this.raca);
animal.setPeso(this.peso);
animal.setListaDeVacinas(this.listaDeVacinas);
return animal ;
}



}
