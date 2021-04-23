package hack.api.com.dto;

public class TokenDTO {

	private String token ;
	public TokenDTO(String token, String tipo) {
		super();
		this.token = token;
		this.tipo = tipo;
	}
	private String tipo ;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
