package hack.api.com.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hack.api.com.modelo.Animal;


public class AnimalDTO implements Serializable {

	public AnimalDTO() {}
	
	private Long id;
	private String nome;
	private String raca;
	private int peso;
	private List<VacinaDTO> vacinas = new ArrayList<>();

	public AnimalDTO(Long id, String nome, String raca, int peso, List<VacinaDTO> vacinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.vacinas = vacinas;
	}
	
	public AnimalDTO(Animal a) {
		
		id = a.getId();
		nome = a.getNome();
		raca = a.getRaca();
		peso = a.getPeso();		
		
		vacinas = a.getVacinas().stream().map(x -> new VacinaDTO(x))
				.collect(Collectors.toList());

	}
	
	

	private static final long serialVersionUID = 1L;



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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public List<VacinaDTO> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<VacinaDTO> vacinas) {
		this.vacinas = vacinas;
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
		AnimalDTO other = (AnimalDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
