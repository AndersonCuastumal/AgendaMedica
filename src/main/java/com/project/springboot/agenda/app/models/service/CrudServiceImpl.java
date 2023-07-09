package com.project.springboot.agenda.app.models.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.agenda.app.models.dao.ICitaDao;
import com.project.springboot.agenda.app.models.dao.IHorarioDao;
import com.project.springboot.agenda.app.models.dao.IMedicoDao;
import com.project.springboot.agenda.app.models.dao.IPacienteDao;
import com.project.springboot.agenda.app.models.entity.Cita;
import com.project.springboot.agenda.app.models.entity.Horario;
import com.project.springboot.agenda.app.models.entity.Medico;
import com.project.springboot.agenda.app.models.entity.Paciente;


@Service
public class CrudServiceImpl implements ICrudService{
	
	@Autowired
	private IMedicoDao medicoDao;
	
	@Autowired
	private IPacienteDao pacienteDao;
	
	
	@Autowired
	private IHorarioDao horarioDao;

	@Autowired
	private ICitaDao citaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Medico> findAll() {
		// TODO Auto-generated method stub
		return (List<Medico>) medicoDao.findAll();
	}

	
	//---- Metodos Medico
	@Override
	@Transactional
	public void save(Medico medico) {
		// TODO Auto-generated method stub
		medicoDao.save(medico);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Medico findOne(Long id) {
		// TODO Auto-generated method stub
		return medicoDao.findById(id).orElse(null);
	}

	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		medicoDao.deleteById(id);
	}


	@Override
	public Page<Medico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return medicoDao.findAll(pageable);
	}

	
	// --- Metodos Paciente

	@Override
	public List<Paciente> findAllPaciente() {
		// TODO Auto-generated method stub
		return (List<Paciente>) pacienteDao.findAll();
	}


	@Override
	public void savePaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteDao.save(paciente);
	}


	@Override
	public Paciente findPacienteById(Long id) {
		// TODO Auto-generated method stub
		return pacienteDao.findById(id).orElse(null);
	}


	@Override
	public void deletePaciente(Long id) {
		// TODO Auto-generated method stub
		pacienteDao.deleteById(id);
	}


	@Override
	public Page<Paciente> findAllPaciente(Pageable pageable) {
		// TODO Auto-generated method stub
		return pacienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
    public List<Horario> getHorariosByMedicoId(Long medicoId) {
        Medico medico = medicoDao.findById(medicoId).orElse(null);
        if (medico == null) {
            return Collections.emptyList();
        }
        return medico.getHorarios();
    }

	@Override
	@Transactional(readOnly=true)
	public List<Horario> findAllHorario() {
		// TODO Auto-generated method stub
		return (List<Horario>) horarioDao.findAll();
	}


	@Override
	public void saveCita(Cita cita) {
		// TODO Auto-generated method stub
		citaDao.save(cita);
	}




}
