package com.project.springboot.agenda.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.web.SecurityFilterChain;

import com.project.springboot.agenda.app.auth.handler.LoginSuccessHandler;
import com.project.springboot.agenda.app.models.service.JpaUsuariosDetailsService;



@Configuration
public class SpringSecurityConfig {
 
	@Autowired
	private JpaUsuariosDetailsService userDetailsService;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
 
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> {
                try {
                    authz.requestMatchers("/", "/css/**", "/js/**", "/images/**", "/paciente/listapacientes").permitAll()
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
		                    .successHandler(successHandler)
		                    .loginPage("/login")
		                .permitAll()
		            .and()
		            .logout().permitAll()
		            .and()
		            .exceptionHandling().accessDeniedPage("/error_404");
		
		    } catch (Exception e) {
		            e.printStackTrace();
		    }
		});
		
		return http.build();
    }
    
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);

	}
 
}