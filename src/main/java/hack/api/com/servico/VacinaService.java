package hack.api.com.servico;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hack.api.com.dto.VacinaDTO;

import hack.api.com.modelo.Vacina;
import hack.api.com.modelo.interfaces.MeuCrud;
import hack.api.com.repositorio.VacinaRepositorio;

@Service
public class VacinaService implements MeuCrud<VacinaDTO, Vacina> {

	@Autowired
	VacinaRepositorio rps;

	@Transactional(readOnly = true)
	public List<VacinaDTO> findAll() {
		List<Vacina> lista = rps.findAll();
		return lista.stream().map(vacina -> new VacinaDTO(vacina)).collect(Collectors.toList());
	}

	@Transactional
	public List<VacinaDTO> saveAll(List<Vacina> lista) {
		Iterable<Vacina> it = lista;
		List<Vacina> dto = rps.saveAll(it);
		return dto.stream().map(vacina -> new VacinaDTO(vacina)).collect(Collectors.toList());
	}

	@Transactional
	public VacinaDTO save(Vacina vacina) {
		return new VacinaDTO(rps.save(vacina));
	}

	@Override
	public VacinaDTO edit(Vacina vcn) {
		Vacina v = null;
		if (rps.existsById(vcn.getId())) {
			v = rps.save(vcn);
		}
		return new VacinaDTO(v);
	}

	@Override
	public void delete(Long id) {
		if (rps.existsById(id)) {
			rps.delete(rps.findById(id).get());
		} else {
			System.out.println("---------ANIMAL NÃO EXISTE---------");
		}

	}

	@Override
	public VacinaDTO findById(Long id) {
		return new VacinaDTO(rps.findById(id).get());
	}

	@Override
	public List<VacinaDTO> findAllByName(String pedaco) {
		List<Vacina> dto = rps.findAllByName(pedaco);
		return dto.stream().map(vcn -> new VacinaDTO(vcn)).collect(Collectors.toList());
	}

}
