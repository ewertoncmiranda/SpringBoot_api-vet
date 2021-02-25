package miranda.cordeiro.vet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.cordeiro.vet.entity.MedicalConsultation;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConsultationDTO {
	
	private Long id ;
	
	private String date ;
	
	private MedicalDoctorDTO doctor ;	
	
	private OwnerDTO owner ;	
	
	private AnimalDTO animal ;
	
	public MedicalConsultationDTO(MedicalConsultation consultation) {
		id = consultation.getId();
		date = consultation.getDate();
		doctor = new MedicalDoctorDTO(consultation.getDoctor());
		owner = new OwnerDTO (consultation.getOwner());
		animal = new AnimalDTO(consultation.getAnimal());
	}
	
	
	
}
