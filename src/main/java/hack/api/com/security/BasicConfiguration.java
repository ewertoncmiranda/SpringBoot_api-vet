package hack.api.com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
        .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/ola")
                .hasAuthority("SCOPE_authorities")
                .anyRequest().authenticated().and().oauth2ResourceServer().jwt();
    }

    //openid profile email authorities
}
