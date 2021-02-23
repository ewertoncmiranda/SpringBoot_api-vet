package miranda.cordeiro.vet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miranda.cordeiro.vet.constant.AnimalType;

@Entity
@Table(name = "ANIMAL_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id ;
	
	private String name ;
	
	private AnimalType size;
	
	
}
