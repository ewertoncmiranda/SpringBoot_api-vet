package hack.api.com.config.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket config () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() 
				.apis(RequestHandlerSelectors.basePackage("hack.api.com.controller"))
				.paths(PathSelectors.any()) .build() .apiInfo(info()) ;
		
	}
	
	public ApiInfo info() {
		return new ApiInfo("",
				"Controle de Clinica Veterinária ",
				"1.0", "Terms of Service", new springfox.documentation.service.Contact
				("Ewerton Cordeiro Miranda", "https://github.com/ewertoncmiranda", "sonardevplus@gmail.com"),
				"Apache License Version 2.0" ,
				"https://www.apache.org/licenses/LICENSE-2.0" , 
				new ArrayList<VendorExtension>());
	}

}
