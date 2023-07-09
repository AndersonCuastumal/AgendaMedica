package com.project.springboot.agenda.app.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.springboot.agenda.app.models.entity.Cita;
import com.project.springboot.agenda.app.models.entity.Horario;
import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.entity.Paciente;
import com.project.springboot.agenda.app.models.service.ICrudService;


import jakarta.validation.Valid;



@Controller
@RequestMapping("/cita")
@SessionAttributes("cita")
public class CitaController {
	
	private final Logger log=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICrudService crudService;
	
	@GetMapping("/form/{id}")
	public String crear(@PathVariable(value="id") Long id,
			Map<String,Object> model, 
			RedirectAttributes flash		
			) {
		
		Paciente paciente=crudService.findPacienteById(id);
		
		if(paciente==null) {
			flash.addFlashAttribute("error", "El medico o paciente no existe en la base de datos");
			return "redirect:/paciente/listapacientes";
		}
		
		Cita cita=new Cita();
		

		cita.setPaciente(paciente);
		
		List<Medico> medicos=crudService.findAll();
		
		model.put("cita", cita);
		model.put("medicos",medicos);
		model.put("titulo", "Agendar Cita Medica");
		return "cita/form";
	}
	
	

	@GetMapping(value="/horarios/{medicoId}/{fecha}",produces={"application/json"})
	public @ResponseBody List<Horario> getHorariosDisponibles(@PathVariable Long medicoId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha
			) {
	    List<Horario> horarios = crudService.getHorariosByMedicoId(medicoId,fecha);

		return horarios;
	}
		
	
	@RequestMapping( value="/form",method=RequestMethod.POST)
	public String guardar(@Valid Cita cita, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Agendar Cita Medica");
			log.error("paciente id: ".concat(" "+cita.getPaciente().getId()));

			return "redirect:/cita/form/"+cita.getPaciente().getId();
		}
		
		String mensajeFlash = (cita.getId() != null) ? "cita actualizada con Exito!" : "Cita creada con éxito";
		crudService.saveCita(cita);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/paciente/consultarpaciente/"+cita.getPaciente().getId();
	}

	
	@RequestMapping(value="/formedit/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Cita cita=null;
		
	
		cita = crudService.findCitaById(id);

		if (cita == null || id<=0) {
			// Agregamos mensaje flash
			flash.addFlashAttribute("error", "El ID del cita no existe en la BD");
			return "redirect:/paciente/listapacientes";
		}
		
		
		
		Paciente paciente=cita.getPaciente();
		
		if(paciente==null) {
			flash.addFlashAttribute("error", "El medico o paciente no existe en la base de datos");
			return "redirect:/paciente/listapacientes";
		}
		

		

		cita.setPaciente(paciente);
		
		List<Medico> medicos=crudService.findAll();
		
		model.put("cita", cita);
		model.put("medicos",medicos);
		model.put("titulo", "Editar Cita");
		return "cita/form";
	}
	
	// Metodo ver detalle de la factura
	
	
	
	
	
	
		@GetMapping("/consultar/{id}")
		public String ver(@PathVariable(value="id") Long id,
				Model model,
				RedirectAttributes flash) {
			Cita cita=crudService.findCitaById(id);
			
			if(cita==null) {
				flash.addFlashAttribute("error", "La cita no existe en la base de datos!");
				return "redirect:/login";
			}
			model.addAttribute("cita", cita);
			model.addAttribute("titulo", "Cita: ".concat(cita.getDescripcion()));
			return "cita/consultar";
		}
		
		//
		@GetMapping("/cancelar/{id}")
		public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
			Cita cita=crudService.findCitaById(id);
			if(cita!=null) {
				crudService.deleteCita(id);
				flash.addFlashAttribute("success", "Cita cancelada con éxito!");
				return "redirect:/paciente/consultarpaciente/"+cita.getPaciente().getId();
			}
			flash.addFlashAttribute("error", "La cita no existe en la BD, no se pudo cancelar!");
			return "redirect:/login";
		}
		
		
		


	
	
	
	
}
