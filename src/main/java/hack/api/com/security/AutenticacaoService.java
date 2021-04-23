package hack.api.com.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hack.api.com.modelo.user.UsuarioSistema;
import hack.api.com.repositorio.UsuarioSistemaRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioSistemaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioSistema> usuario = repository.findByNome(username);

		if (usuario.isPresent()) {
			return usuario.get();
		}

		throw new UsernameNotFoundException("Dados Inválidos!");
	}

}
