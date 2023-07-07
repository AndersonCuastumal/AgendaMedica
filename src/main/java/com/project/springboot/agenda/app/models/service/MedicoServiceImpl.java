package com.project.springboot.agenda.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.agenda.app.models.dao.IMedicoDao;

import com.project.springboot.agenda.app.models.entity.Medico;


@Service
public class MedicoServiceImpl implements IMedicoService{
	
	@Autowired
	private IMedicoDao medicoDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Medico> findAll() {
		// TODO Auto-generated method stub
		return (List<Medico>) medicoDao.findAll();
	}

	
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

}
