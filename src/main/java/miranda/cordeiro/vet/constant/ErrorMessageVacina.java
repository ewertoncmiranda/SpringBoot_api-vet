package miranda.cordeiro.vet.constant;

public enum ErrorMessageVacina {
	
	ERROR_FIND_VACINA("Erro ao procurar Vacina.") ,
	ERROR_SAVE_NEW_VACINA("Erro ao salvar novo Vacina."),
	ERROR_UPDATE_VACINA_BY_ID("Erro ao atualizar Vacina. Vacina não existe na base de dados."),
	ERRO_DELETE_VACINA("Erro ao deletar Vacina. ");
	
	private final String value ;
	
	private ErrorMessageVacina(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
