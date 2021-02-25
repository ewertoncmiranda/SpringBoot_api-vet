package miranda.cordeiro.vet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miranda.cordeiro.vet.entity.MedicalDoctor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalDoctorDTO {

	private Long id ;
	
	private String name ;
	
	private String telephone ;
	
	private String crm ;
	
	public MedicalDoctorDTO(MedicalDoctor doctor) {
		id = doctor.getId();
		name = doctor.getName();
		telephone = doctor.getTelephone();
		crm = doctor.getCrm();
	}
	
	
}
