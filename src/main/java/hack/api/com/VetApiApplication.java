package hack.api.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"hack.api.com.modelo","hack.api.com.repositorio"})
@EnableAutoConfiguration
public class VetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetApiApplication.class, args);
	}
	
	
	

}
