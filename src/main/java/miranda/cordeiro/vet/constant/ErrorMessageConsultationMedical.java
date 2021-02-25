package miranda.cordeiro.vet.constant;

public enum ErrorMessageConsultationMedical {
	
	ERROR_FIND_CONSULTATION("Erro ao procurar Consulta.") ,
	ERROR_SAVE_NEW_CONSULTATION("Erro ao salvar novo Consulta."),
	ERROR_UPDATE_CONSULTATION_BY_ID("Erro ao atualizar Consulta. Consulta não existe na base de dados."),
	ERRO_DELETE_CONSULTATION("Erro ao deletar Consulta. "),
	ERRO_GENERATE_CONSULTATION("Erro ao criar Consulta");
		
	private final String value ;
	
	private ErrorMessageConsultationMedical(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
