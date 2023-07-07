package com.project.springboot.agenda.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.project.springboot.agenda.app.models.service.IPacienteService;
import com.project.springboot.agenda.app.util.paginator.PageRender;


import jakarta.validation.Valid;

@Controller
@SessionAttributes("paciente")
public class PacienteController {
	
	
	@Autowired

	private IPacienteService pacienteService;
	
	@RequestMapping(value="listapacientes", method=RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4); // Anuestra paginacion se agregara 4 registros por pagina
		Page<Paciente> pacientes = pacienteService.findAll(pageRequest);// En clientes tenemos la lista paginada

		PageRender<Paciente> pageRender = new PageRender<>("/listapacientes", pacientes);

		model.addAttribute("titulo", "Listado de Pacientes");

		model.addAttribute("pacientes", pacientes); 
		model.addAttribute("page", pageRender);
		
		return "listapacientes";
	}
	
	@RequestMapping(value="/formpaciente")
	public String crear(Map<String, Object> model) {
		Paciente paciente =new Paciente();
		model.put("paciente", paciente);
		model.put("titulo", "Formulario de paciente");
		return "formpaciente";
	}
	
	@RequestMapping( value="/formpaciente",method=RequestMethod.POST)
	public String guardar(@Valid Paciente paciente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de paciente");
			
			return "formpaciente";
		}
		
		String mensajeFlash = (paciente.getId() != null) ? "Paciente actualizado con Exito!" : "Paciente creado con éxito";
		pacienteService.save(paciente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listapacientes";
	}
	
	
	@RequestMapping(value="/formpaciente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Paciente paciente=null;
		
		if (id > 0) {
			paciente = pacienteService.findOne(id);

			if (paciente == null) {
				// Agregamos mensaje flash
				flash.addFlashAttribute("error", "El ID del cliente no existe en la BD");
				return "redirect:/listarpacientes";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listarpacientes";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Editar Paciente");
		return "formpaciente";
	}
	
	@RequestMapping(value="/eliminarpaciente/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0) {

	
			pacienteService.delete(id);
			flash.addFlashAttribute("success", "Paciente eliminado con éxito!!");

			

		}
		return "redirect:/listapacientes";
		
	}
	
	
	@GetMapping(value = "/consultarpaciente/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Paciente paciente = pacienteService.findOne(id);
		

		if (paciente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la BD");
			return "redirect:/listapacientes";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Detalle del paciente: " + paciente.getNombre());
		return "consultarpaciente";
	}
	
	
}