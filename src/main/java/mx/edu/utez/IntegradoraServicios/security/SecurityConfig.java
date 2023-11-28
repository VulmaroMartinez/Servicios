package mx.edu.utez.IntegradoraServicios.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.csrf( c -> c.disable())
               .authorizeRequests().requestMatchers("/login", "/login/oauth2/code/google").permitAll()
               .anyRequest().authenticated()
                .and().oauth2Login( oauth -> oauth.loginPage("/login").defaultSuccessUrl("/index"));
        return http.build();
    }

}
