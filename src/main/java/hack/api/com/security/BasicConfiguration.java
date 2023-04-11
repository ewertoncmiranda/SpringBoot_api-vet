package hack.api.com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
        .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/ola")
                .hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated().and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(converter());
    }


    JwtAuthenticationConverter converter(){
        JwtGrantedAuthoritiesConverter  converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthoritiesClaimName("user_name");
        converter.setAuthorityPrefix("");
        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
        return authenticationConverter;
    }
    //openid profile email authorities
}
