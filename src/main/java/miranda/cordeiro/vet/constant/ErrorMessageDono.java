package miranda.cordeiro.vet.constant;

public enum ErrorMessageDono {
	
	ERROR_FIND_OWNER("Erro ao procurar Dono.") ,
	ERROR_SAVE_NEW_OWNER("Erro ao salvar novo Dono."),
	ERROR_UPDATE_OWNER_BY_ID("Erro ao atualizar Dono. Dono não existe na base de dados."),
	ERRO_DELETE_OWNER("Erro ao deletar Dono.") ;
	
	private final String value ;
	
	private ErrorMessageDono(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
