package miranda.cordeiro.vet.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="MEDICAL_DOCTOR_TB")
public class MedicalDoctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3641060221428422437L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;

	private String name ;
	
	private String telephone ;
	
	private String crm ;
	
}
