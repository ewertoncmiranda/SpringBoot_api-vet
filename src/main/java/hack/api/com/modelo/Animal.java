package hack.api.com.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "ANIMAL_TBL")
public class Animal implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animal_id")
	private Long animal_id ;
	
	
	private String nome ;
	
	private String raca ;
	
	private Integer peso ;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER ,optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "dono_id"))
	private Dono dono ;
	
	@ManyToMany
	@JoinTable(name="animal_tem_vacina",joinColumns = {@JoinColumn(name ="animal_id")} ,inverseJoinColumns = {@JoinColumn(name="vacina_id")})
	private List<Vacina> listaDeVacinas ; 
	
}
