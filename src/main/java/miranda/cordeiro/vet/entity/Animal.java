package miranda.cordeiro.vet.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miranda.cordeiro.vet.constant.AnimalType;

@Entity
@Table(name = "TB_ANIMAL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "animal_id")
	private Long id ;
	
	private String name ;
	
	private AnimalType size;
		
	@ManyToMany
	@JoinTable(name = "TB_ANIMAL_VACINA",joinColumns = @JoinColumn(name="animal_id"),inverseJoinColumns = @JoinColumn(name = "vacina_id") )
	private List<Vacina> vacinaList = new ArrayList<>();
	
	
}
