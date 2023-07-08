package com.project.springboot.agenda.app.controllers;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.springboot.agenda.app.models.entity.Paciente;
import com.project.springboot.agenda.app.models.service.ICrudService;

import com.project.springboot.agenda.app.util.paginator.PageRender;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/paciente")
@SessionAttributes("paciente")
public class PacienteController {
	
	private final Logger log=LoggerFactory.getLogger(getClass());
	@Autowired

	private ICrudService pacienteService;
	
	@RequestMapping(value="/listapacientes", method=RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page,
			Model model,
			Authentication authentication,
			HttpServletRequest request) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		SecurityContextHolderAwareRequestWrapper securityContext =new SecurityContextHolderAwareRequestWrapper(request, "");
		if(securityContext.isUserInRole("ADMIN")) {
			log.info("SecurityContextHolderAwareRequestWrapper: inicio sesion ".concat(auth.getName()).concat(" Tienes acceso"));
		}else {
			log.info("SecurityContextHolderAwareRequestWrapper: inicio sesion ".concat(auth.getName()).concat("No Tienes acceso"));
		}
		
		Pageable pageRequest = PageRequest.of(page, 4); // Anuestra paginacion se agregara 4 registros por pagina
		Page<Paciente> pacientes = pacienteService.findAllPaciente(pageRequest);// En clientes tenemos la lista paginada

		PageRender<Paciente> pageRender = new PageRender<>("/paciente/listapacientes", pacientes);

		model.addAttribute("titulo", "Listado de Pacientes");

		model.addAttribute("pacientes", pacientes); 
		model.addAttribute("page", pageRender);
		
		return "paciente/listapacientes";
	}
	
	@RequestMapping(value="/formpaciente")
	public String crear(Map<String, Object> model) {
		Paciente paciente =new Paciente();
		model.put("paciente", paciente);
		model.put("titulo", "Formulario de paciente");
		return "paciente/formpaciente";
	}
	
	@RequestMapping( value="/formpaciente",method=RequestMethod.POST)
	public String guardar(@Valid Paciente paciente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de paciente");
			
			return "paciente/formpaciente";
		}
		
		String mensajeFlash = (paciente.getId() != null) ? "Paciente actualizado con Exito!" : "Paciente creado con éxito";
		pacienteService.savePaciente(paciente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/paciente/listapacientes";
	}
	
	
	@RequestMapping(value="/formpaciente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Paciente paciente=null;
		
		if (id > 0) {
			paciente = pacienteService.findPacienteById(id);

			if (paciente == null) {
				// Agregamos mensaje flash
				flash.addFlashAttribute("error", "El ID del paciente no existe en la BD");
				return "redirect:/paciente/listapacientes";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del paciente no puede ser cero!");
			return "redirect:/paciente/listapacientes";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Editar Paciente");
		return "paciente/formpaciente";
	}
	
	@RequestMapping(value="/eliminarpaciente/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0) {

	
			pacienteService.deletePaciente(id);
			flash.addFlashAttribute("success", "Paciente eliminado con éxito!!");

			

		}
		return "redirect:/paciente/listapacientes";
		
	}
	
	
	@GetMapping(value = "/consultarpaciente/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Paciente paciente = pacienteService.findPacienteById(id);
		

		if (paciente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la BD");
			return "redirect:/paciente/listapacientes";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Detalle del paciente: " + paciente.getNombre());
		return "paciente/consultarpaciente";
	}
	
	
	private boolean hasRole(String role) {
		SecurityContext context=SecurityContextHolder.getContext();
		if(context==null) {
			return false;
		}
		
		Authentication auth =context.getAuthentication();
		
		if(auth==null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities=auth.getAuthorities();
		
		return authorities.contains(new SimpleGrantedAuthority(role));
	}
	
}