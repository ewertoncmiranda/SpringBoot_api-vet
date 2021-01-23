package hack.api.com.dto;

import hack.api.com.modelo.Vacina;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class VacinaDTO {
	
	private Long id;

	private String nome;

	private Integer lote;

	public VacinaDTO(){}
	
	public VacinaDTO(Long id, String nome, Integer lote) {
		this.id = id;
		this.nome = nome;
		this.lote = lote;
	}

	public VacinaDTO(Vacina v) {
		id = v.getId();
		nome = v.getNome();
		lote = v.getLote();
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

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
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
		VacinaDTO other = (VacinaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
