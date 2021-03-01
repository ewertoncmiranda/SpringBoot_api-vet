package miranda.cordeiro.vet.constant;

public enum AnimalType {

	LITTLE_SIZE("Pequeno porte.") ,
	MEDIUM_SIZE("Médio porte."),
	BIG_SIZE("Grande porte.");
	
	private String value ;
	
	private AnimalType(String type) {
	this.value = type	;
	}
	
	public String getValue() {
		return value ;
	}  /**/
	
	
}
