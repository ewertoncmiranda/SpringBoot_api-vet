package hack.api.com.dto;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import hack.api.com.modelo.Dono;


public class DonoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String CPF;
	private Integer idade ;
	private List<AnimalDTO> animais ;
	
	public DonoDTO() {		
	}	
	
	public DonoDTO(Long id , String nome , String CPF ,Integer idade) {
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
	}
	
	public DonoDTO(Dono dono) {
	 id = dono.getId();
	 nome = dono.getNome();
	 CPF = dono.getCPF();
	 idade = dono.getIdade();
	 animais = dono.getAnimais()
			 	   .stream().map(x -> new AnimalDTO(x)).collect(Collectors.toList());	 
			 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<AnimalDTO> getAnimais() {
		return animais;
	}

	public void setAnimais(List<AnimalDTO> animais) {
		this.animais = animais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonoDTO other = (DonoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 

	
}
