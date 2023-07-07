package com.project.springboot.agenda.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.springboot.agenda.app.models.entity.Paciente;


public interface IPacienteService {
	public List<Paciente> findAll();
	public void save(Paciente paciente);
	public Paciente findOne(Long id);
	public void delete(Long id);
	public Page<Paciente> findAll(Pageable pageable);
}
