package hack.api.com.utilidade;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hack.api.com.dto.AnimalDTO;
import hack.api.com.dto.DonoDTO;
import hack.api.com.dto.VacinaDTO;
import hack.api.com.modelo.Animal;
import hack.api.com.modelo.Dono;
import hack.api.com.modelo.Vacina;
import hack.api.com.repositorio.AnimalRepositorio;
import hack.api.com.servico.AnimalService;
import hack.api.com.servico.DonoService;
import hack.api.com.servico.VacinaService;


public class ActData {

	@Autowired
	AnimalService repAnimal;

	@Autowired
	DonoService repDono;

	@Autowired
	VacinaService repVacina;	
		


	

	public List<AnimalDTO> adicionaAnimais() {
		List<Animal> list = new ArrayList<>();

		Animal animal;

		for (int count = 0; count < 10; count++) {

			animal = new Animal();
			animal.setPeso(count + 2);
			animal.setRaca("Vira-Lata");
			animal.setNome(" 0" + count + "Dog" + count);

			list.add(animal);
		}
		List<AnimalDTO> listaDto = repAnimal.saveAll(list);
		return listaDto;
	}

	
	public List<DonoDTO> adicionarDonos() {
		List<Dono> lista = new ArrayList<>();

		Dono dono;

		for (int x = 0; x < 20; x++) {
			dono = new Dono();
			dono.setCPF("00" + x * 2 + ".0" + x * 3 + 1 + "0.00" + x++ * 5 + 1 + ".00");
			dono.setIdade(1+x);
			dono.setNome("User" + x + " ");
			lista.add(dono);
		}
		return repDono.saveAll(lista);

	}

	
	public List<VacinaDTO> adicionarVacinas() {
		List<Vacina> lista = new ArrayList<>();

		Vacina vcn;

		for (int x = 0; x < 20; x++) {
			vcn = new Vacina();
			vcn.setNome("Vacina " + x * 2);
			vcn.setLote(x * 2 + 1);
			lista.add(vcn);
		}

		return repVacina.saveAll(lista);

	}
}
