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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OWNER_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "telephone")
	private String telephone ;						
		
	@OneToMany
	@JoinColumn(name = "dono_id")
	private List<Animal> animalList = new ArrayList<>();
	
}
