package hack.api.com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hack.api.com.dto.TokenDTO;
import hack.api.com.security.TokenService;
import hack.api.com.security.dto.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService ;

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication auth = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(auth);
			System.out.println(token);
			return ResponseEntity.ok().body(new TokenDTO(token,"bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
