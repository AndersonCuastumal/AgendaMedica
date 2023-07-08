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

import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.service.ICrudService;


import com.project.springboot.agenda.app.util.paginator.PageRender;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/medico")
@SessionAttributes("medico")
public class MedicoController {
	@Autowired

	private ICrudService medicoService;
	
	@RequestMapping(value="/listamedicos", method=RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4); // Anuestra paginacion se agregara 4 registros por pagina
		Page<Medico> medicos = medicoService.findAll(pageRequest);// En clientes tenemos la lista paginada

		PageRender<Medico> pageRender = new PageRender<>("/medico/listamedicos", medicos);

		model.addAttribute("titulo", "Listado de Medicos");

		model.addAttribute("medicos", medicos); 
		model.addAttribute("page", pageRender);
		
		return "medico/listamedicos";
	}
	
	@RequestMapping(value="/formmedico")
	public String crear(Map<String, Object> model) {
		Medico medico =new Medico();
		model.put("medico", medico);
		model.put("titulo", "Formulario de medico");
		return "medico/formmedico";
	}
	
	@RequestMapping( value="/formmedico",method=RequestMethod.POST)
	public String guardar(@Valid Medico medico, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de medico");
			
			return "medico/formmedico";
		}
		
		String mensajeFlash = (medico.getId() != null) ? "Medico actualizado con Exito!" : "Medico creado con éxito";
		medicoService.save(medico);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/medico/listamedicos";
	}
	
	
	@RequestMapping(value="/formmedico/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Medico medico=null;
		
		if (id > 0) {
			medico = medicoService.findOne(id);

			if (medico == null) {
				// Agregamos mensaje flash
				flash.addFlashAttribute("error", "El ID del medico no existe en la BD");
				return "redirect:/medico/listamedicos";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del medico no puede ser cero!");
			return "redirect:/medico/listamedicos";
		}
		model.put("medico", medico);
		model.put("titulo", "Editar Medico");
		return "medico/formmedico";
	}
	
	@RequestMapping(value="/eliminarmedico/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0) {

	
			medicoService.delete(id);
			flash.addFlashAttribute("success", "Medico eliminado con éxito!!");

			

		}
		return "redirect:/medico/listamedicos";
		
	}
	
	
	@GetMapping(value = "/consultarmedico/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Medico medico = medicoService.findOne(id);
		

		if (medico == null) {
			flash.addFlashAttribute("error", "El medico no existe en la BD");
			return "redirect:/medico/listamedicos";
		}
		
		
		model.put("medico", medico);
		model.put("titulo", "Detalle del medico: " + medico.getNombre());
		return "medico/consultarmedico";
	}
}
