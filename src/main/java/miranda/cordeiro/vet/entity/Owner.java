package miranda.cordeiro.vet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_OWNER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "telephone")
	private String telephone ;						
		
	
}
