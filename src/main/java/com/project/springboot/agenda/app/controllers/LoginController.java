package com.project.springboot.agenda.app.controllers;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {
	@GetMapping({"/login","/","/home"})
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if (principal != null) {
			// Obtener la autenticación actual
		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		    // Obtener los roles del usuario autenticado
		    List<String> roles = authentication.getAuthorities().stream()
		            .map(GrantedAuthority::getAuthority)
		            .collect(Collectors.toList());

		    // Verificar si el usuario tiene un rol específico
		    if (roles.contains("ROLE_ADMIN")) {
		    	return "redirect:/paciente/listapacientes";
		    }
            
            // Redirigir al paciente a su página de consulta utilizando su ID
            return "redirect:/paciente/perfil";
            
        }
		
		if(error!=null) {
			model.addAttribute("error", "Error en el inicio de sesión: Nombre de usuario o contraseña  incorrecta");
		}
		
		if(logout!=null) {
			model.addAttribute("success", "El cierre de sesión fue exitoso");
		}
		
		return "login";
	}
	
	
	
	
}
