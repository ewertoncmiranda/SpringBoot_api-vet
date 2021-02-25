package miranda.cordeiro.vet.constant;

public enum ErrorMessageMedicalDoctor {
	
	ERROR_FIND_DOCTOR("Erro ao procurar Médico.") ,
	ERROR_SAVE_NEW_DOCTOR("Erro ao salvar novo Médico."),
	ERROR_UPDATE_DOCTOR_BY_ID("Erro ao atualizar Médico. Médico não existe na base de dados."),
	ERRO_DELETE_DOCTOR("Erro ao deletar Médico. ");
	
	
	private final String value ;
	
	private ErrorMessageMedicalDoctor(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
