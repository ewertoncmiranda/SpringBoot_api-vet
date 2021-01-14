package hack.api.com.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import hack.api.com.modelo.Dono;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
	 

	
}
