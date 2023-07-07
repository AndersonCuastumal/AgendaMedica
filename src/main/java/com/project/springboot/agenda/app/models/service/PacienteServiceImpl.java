package com.project.springboot.agenda.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.agenda.app.models.dao.IPacienteDao;
import com.project.springboot.agenda.app.models.entity.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired
	private IPacienteDao pacienteDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>) pacienteDao.findAll();
	}

	
	@Override
	@Transactional
	public void save(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteDao.save(paciente);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Paciente findOne(Long id) {
		// TODO Auto-generated method stub
		return pacienteDao.findById(id).orElse(null);
	}

	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteDao.deleteById(id);
	}


	@Override
	public Page<Paciente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return pacienteDao.findAll(pageable);
	}

}
