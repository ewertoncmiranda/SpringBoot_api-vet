package miranda.cordeiro.vet.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MEDICAL_CONSULTATION_TB")
public class MedicalConsultation implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String date ;

	@OneToOne
	@JoinColumn(name = "doctor_id")
	private MedicalDoctor doctor ;
	
	@OneToOne
	@JoinColumn(name ="owner_id")
	private Owner owner ;
	
	@OneToOne
	@JoinColumn(name="animal_id")
	private Animal animal ;
	
}
