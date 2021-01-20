package hack.api.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "dono_tbl")
public class Dono implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String nome ;
	
	private int idade ;
	
	private String CPF ;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_id")
	private List<Animal> animais = new ArrayList<>();
	
	public Dono() {};
	public Dono(Long id , String nome , String CPF ,Integer idade){
		this.id = id;
		this.nome = nome ;
		this.CPF = CPF ;
		this.idade = idade;
	}
		

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	
	public Long getId() {
		return id;
	}

	public void setDonoId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

		
	

}
