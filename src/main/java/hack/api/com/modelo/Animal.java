package hack.api.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@Entity
@Table(name = "animal_tbl")
public class Animal implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
		
	private String nome ;
	
	private String raca ;
	
	private Integer peso ;
	
	@ManyToMany
	@JoinTable(name = "tb_animal_vacina",
			   joinColumns = @JoinColumn(name ="animal_id"),
			   inverseJoinColumns = @JoinColumn(name ="vacina_id"))
	private List<Vacina> vacinas = new ArrayList<>();
		
	
}
