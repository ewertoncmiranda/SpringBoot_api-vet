package miranda.cordeiro.vet.constant;

public enum ErrorMessage {
	
	ERROR_FIND_OWNER("Erro ao procurar Dono.") ,
	ERROR_SAVE_NEW_OWNER("Erro ao salvar novo Dono."),
	ERROR_UPDATE_OWNER_BY_ID("Erro ao atualizar Dono. Dono não existe na base de dados.");
	
	private final String value ;
	
	private ErrorMessage(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
