package com.project.springboot.agenda.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.springboot.agenda.app.models.entity.Medico;



public interface IMedicoService {
	public List<Medico> findAll();
	public void save(Medico medico);
	public Medico findOne(Long id);
	public void delete(Long id);
	public Page<Medico> findAll(Pageable pageable);
}
