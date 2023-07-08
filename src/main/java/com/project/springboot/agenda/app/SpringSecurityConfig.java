package com.project.springboot.agenda.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class SpringSecurityConfig {
 
	
	
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
 
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 
        manager.createUser(User.withUsername("user")
                               .password(passwordEncoder().encode("user"))
                               .roles("USER").build());
        
         manager.createUser(User.withUsername("admin")
                               .password(passwordEncoder().encode("admin"))
                               .roles("ADMIN", "USER").build());
 
        return manager;
    }
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
        http.authorizeHttpRequests()
        	.requestMatchers("/","/css/**","/js/**","/login").permitAll()
            .requestMatchers("/paciente/formpaciente/**").hasAnyRole("ADMIN")
            .requestMatchers("/paciente/eliminarpaciente/**").hasAnyRole("ADMIN")
            .requestMatchers("/paciente/consultarpaciente/**").hasAnyRole("USER")
            .requestMatchers("/paciente/listapacientes/**").hasAnyRole("USER")
            .requestMatchers("/medico/listamedicos/**").hasAnyRole("ADMIN")
            .requestMatchers("/medico/formmedico/**").hasAnyRole("ADMIN")
            .requestMatchers("/medico/consultarmedico/**").hasAnyRole("ADMIN")
            .requestMatchers("/medico/eliminarmedico/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
	        .formLogin()
	        	.loginPage("/login")
	            .permitAll()
            .and()
            .logout()
            	.permitAll()
        	.and()
            .exceptionHandling()
            	.accessDeniedPage("/error_404");
 
        return http.build();
    }
 
}