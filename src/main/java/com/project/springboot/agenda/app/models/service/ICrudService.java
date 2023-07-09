package com.project.springboot.agenda.app.models.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.springboot.agenda.app.models.entity.Cita;
import com.project.springboot.agenda.app.models.entity.Horario;
import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.entity.Paciente;



public interface ICrudService {
	public List<Medico> findAll();
	public void save(Medico medico);
	public Medico findOne(Long id);
	public void delete(Long id);
	public Page<Medico> findAll(Pageable pageable);
	
	public List<Paciente> findAllPaciente();
	public void savePaciente(Paciente paciente);
	public Paciente findPacienteById(Long id);
	public void deletePaciente(Long id);
	public Page<Paciente> findAllPaciente(Pageable pageable);
	public Paciente registrarPaciente(Paciente paciente);
	public Paciente findPacienteByCorreo(String correo);
	
	public void saveCita(Cita cita);
	
	public List<Horario> findAllHorario();
	public List<Horario> getHorariosByMedicoId(Long medicoId, LocalDate fecha);
	public Cita findCitaById(Long id);
	public void deleteCita(Long id);
	
	
	
	
}
