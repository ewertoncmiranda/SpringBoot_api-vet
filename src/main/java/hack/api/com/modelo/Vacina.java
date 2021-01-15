package hack.api.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vacina_tbl")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Vacina implements Serializable{
	
	private static final long serialVersionUID = -3162438318674778208L;
	/**
	 * 
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id")
	private Long id ;
	
	private String nome ;
	
	private Integer lote ;	
	
}
