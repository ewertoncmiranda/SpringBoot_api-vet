package miranda.cordeiro.vet.constant;

public enum ErrorMessageAnimal {
	
	ERROR_FIND_ANIMAL("Erro ao procurar Animal.") ,
	ERROR_SAVE_NEW_ANIMAL("Erro ao salvar novo Animal."),
	ERROR_UPDATE_ANIMAL_BY_ID("Erro ao atualizar Animal. Animal não existe na base de dados."),
	ERRO_DELETE_ANIMAL("Erro ao deletar Animal. "),
	ERRO_ADD_VACINA_TO_ANIMAL("Erro ao adicionar Vacina para Animal.");
	
	private final String value ;
	
	private ErrorMessageAnimal(String errorDescription) {
		value = errorDescription;	
	}
	
	public String getValue() {
		return value;
	}	

}
